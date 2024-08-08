package org.acme.service;

import org.acme.dto.response.CanalDTO;
import org.acme.dto.response.ResultadoDTO;

import java.util.List;
import java.util.Optional;

public interface ICanalService {
    List<CanalDTO> listarCanalesActivos();
    Optional<CanalDTO> consultarCanal(String id);
    ResultadoDTO agregarCanal(CanalDTO canalDTO);
}
