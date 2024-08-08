package org.acme.service;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.acme.dto.response.CanalDTO;
import org.acme.dto.response.ResultadoDTO;
import org.acme.repository.CanalRepository;
import org.acme.utils.MappingUtils;
import org.acme.utils.Respuestas;
import org.acme.utils.valids.ErrorMensaje;
import org.acme.utils.valids.ValidCanal;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.acme.utils.valids.CodigoMensajes.ERROR_EXCEPTION;

@Singleton
@Named("canal-service")
@Slf4j
public class CanalService implements ICanalService {

    @Inject
    private CanalRepository canalRepository;

    @Inject
    private MappingUtils mappingUtils;

    @Inject
    private ValidCanal validCanal;

    @Inject
    private Respuestas respuestas;

    @Override
    public List<CanalDTO> listarCanalesActivos() {
        return canalRepository.listarCanalesActivos().stream().map(canal -> mappingUtils.convertirDe(canal)).toList();
    }

    @Override
    public Optional<CanalDTO> consultarCanal(String id) {
        return canalRepository.obtenerCanalInfo(id).map(canal -> mappingUtils.convertirDe(canal));
    }

    @Override
    public ResultadoDTO agregarCanal(CanalDTO canalDTO) {

        List<String> errores = new LinkedList<>();
        try{
            validCanal.validar(canalDTO).ifPresent(errores::add);
            if(errores.isEmpty())
                canalRepository.save(mappingUtils.convertirDe(canalDTO));
        }catch(Exception ex){
            errores.add(ERROR_EXCEPTION);
            log.error(ex.getMessage(), ex);
        }
        if(errores.isEmpty()){
            return ResultadoDTO.builder()
                    .codigo("00")
                    .ejecutado(true)
                    .errores(null).build();
        }
        return ResultadoDTO.builder()
                .codigo("99")
                .ejecutado(false)
                .errores(respuestas.armarListaErrores(errores, "ES")).build();
    }
}
