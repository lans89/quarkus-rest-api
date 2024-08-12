package org.acme.service.impl;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.acme.client.ApiCurrencyClient;
import org.acme.dto.request.ConsultaTasaCambioDTO;
import org.acme.dto.response.CambioDTO;
import org.acme.dto.response.RestApiCurrencyResponse;
import org.acme.entity.Cambio;
import org.acme.entity.Moneda;
import org.acme.repository.CambioRepository;
import org.acme.repository.MonedaRepository;
import org.acme.service.ITasaCambioService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Named("tasaCambioService")
public class TasaCambioService implements ITasaCambioService {

    @RestClient
    ApiCurrencyClient apiCurrencyClient;
    @Inject
    CambioRepository cambioRepository;
    @Inject
    MonedaRepository monedaRepository;


    private Optional<CambioDTO> convertir(Cambio cambioDB, Moneda monedaDe, Moneda monedaA) {
        return Optional.of(CambioDTO.builder()
                .aMoneda(monedaA.getId())
                .aMonedaNombre(monedaA.getNombre())
                .aMonedaSimbolo(monedaA.getSimbolo())
                .deMoneda(monedaDe.getId())
                .deMonedaNombre(monedaDe.getNombre())
                .deMonedaSimbolo(monedaDe.getSimbolo())
                .fecha(cambioDB.getFecha())
                .tasaCambioVenta(cambioDB.getTasaCambioVenta())
                .tasaCambioCompra(cambioDB.getTasaCambioCompra()).build());
    }

    private Optional<Moneda> validarMoneda(String moneda) {
        return monedaRepository.obtenerInfoMoneda(moneda);
    }

    private Optional<Cambio> obtenerTasaCambioDB(String deMoneda, String aMoneda, LocalDate fecha) {
        return cambioRepository.obtenerTasaCambio(deMoneda, aMoneda, fecha);
    }

    private Optional<Cambio> obtenerTasaCambioApi(String deMoneda, String aMoneda, LocalDate fecha) {
        RestApiCurrencyResponse response = apiCurrencyClient.getCurrencyConverter(deMoneda, aMoneda, fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if (Objects.isNull(response))
            return Optional.empty();
        return Optional.of(Cambio.builder()
                .monedaOrigen(deMoneda)
                .monedaDestino(aMoneda)
                .tasaCambioVenta(response.getData().get(aMoneda).getValue())
                .tasaCambioCompra(response.getData().get(aMoneda).getValue())
                .fecha(fecha).build());
    }

    private void agregarTasaCambio(Cambio tasaCambio) {
        cambioRepository.save(tasaCambio);
    }

    @Override
    public Optional<CambioDTO> obtenerTasaCambio(ConsultaTasaCambioDTO request) {
        log.info("request: {}", request);
        try {
            //validaciones
            Optional<Moneda> monedaDe = this.validarMoneda(request.getDeMoneda());
            if (monedaDe.isEmpty())
                return Optional.empty();
            log.info("monedaDe----");
            Optional<Moneda> monedaA = this.validarMoneda(request.getAMoneda());
            if (monedaA.isEmpty())
                return Optional.empty();
            log.info("monedaA----");
            if (Objects.equals(monedaA.get(), monedaDe.get())) {
                return Optional.empty();
            }
            log.info("Monedas no son iguales!");
            LocalDate fecha = request.getFecha() == null ? LocalDate.now() : LocalDate.parse(request.getFecha(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            log.info("fecha {}", fecha);
            Optional<Cambio> cambio = this.obtenerTasaCambioDB(monedaDe.get().getId(), monedaA.get().getId(), fecha);
            log.info("validaciones");
            //retorna si consulta en base de datos retorno resultados
            if (cambio.isPresent()) {
                return convertir(cambio.get(), monedaDe.get(), monedaA.get());
            }

            //consulta tasa de cambio en un API y si hay resultado salva en base de datos
            cambio = this.obtenerTasaCambioApi(monedaDe.get().getId(), monedaA.get().getId(), fecha);
            log.info("consumo de api");
            if (cambio.isPresent()) {
                this.agregarTasaCambio(cambio.get());
                return convertir(cambio.get(), monedaDe.get(), monedaA.get());
            }
        } catch (Exception ex) {
            log.info(ex.getMessage(), ex);
        }

        //retorna vacio
        return Optional.empty();
    }
}
