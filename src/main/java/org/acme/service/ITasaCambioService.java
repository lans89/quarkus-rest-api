package org.acme.service;

import org.acme.dto.request.ConsultaTasaCambioDTO;
import org.acme.dto.response.CambioDTO;
import org.acme.entity.Cambio;
import org.acme.entity.Moneda;

import java.time.LocalDate;
import java.util.Optional;

public interface ITasaCambioService {
    Optional<CambioDTO> obtenerTasaCambio(ConsultaTasaCambioDTO request);
}
