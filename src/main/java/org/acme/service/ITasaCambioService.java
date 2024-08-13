package org.acme.service;

import org.acme.dto.request.ConsultaTasaCambioDTO;
import org.acme.dto.response.CambioDTO;
import java.util.Optional;

public interface ITasaCambioService {
    Optional<CambioDTO> obtenerTasaCambio(ConsultaTasaCambioDTO request);
}
