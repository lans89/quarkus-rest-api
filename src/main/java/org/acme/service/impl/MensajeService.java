package org.acme.service.impl;

import io.quarkus.cache.CacheResult;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.acme.repository.MensajeRepository;
import org.acme.service.IMensajeService;
import org.acme.utils.valids.ErrorMensaje;

import java.util.Map;
import java.util.stream.Collectors;

@Named("mensajeService")
@Slf4j
public class MensajeService implements IMensajeService {

    @Inject
    private MensajeRepository mensajeRepository;

    @Override
    @CacheResult(cacheName = "mensajes")
    public Map<String, ErrorMensaje> mapaMensajesErrores() {
        log.info("Llamando a la capa DB de mensajes");
        return mensajeRepository.listarMensajesActivos().stream()
                .collect(Collectors.toMap(
                        mensaje -> mensaje.getCodigo()+mensaje.getIdioma(),
                        mensaje -> ErrorMensaje.builder()
                                .codigo(mensaje.getCodigo())
                                .mensaje(mensaje.getMensaje())
                                .excepcionMensaje(mensaje.getMensajeTecnico()).build()));
    }
}
