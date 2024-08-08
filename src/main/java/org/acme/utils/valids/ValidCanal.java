package org.acme.utils.valids;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.acme.dto.response.CanalDTO;
import org.acme.repository.CanalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.acme.utils.valids.CodigoMensajes.*;

@Singleton
public class ValidCanal {

    @Inject
    private CanalRepository canalRepository;

    private final List<String> estados = List.of("TRUE", "FALSE");

    public Optional<String> validar(CanalDTO canalDTO){

        if(Objects.isNull(canalDTO)){
            return Optional.of(ERROR_REQUEST_NULL);
        }

        if(Objects.isNull(canalDTO.getId()) || canalDTO.getId().isBlank()){
            return Optional.of(ERROR_ID_NULL);
        }

        if(canalRepository.existsById(canalDTO.getId())){
            return Optional.of(ERROR_REGISTERED_ID);
        }

        if(Objects.isNull(canalDTO.getNombre()) || canalDTO.getNombre().isBlank()){
            return Optional.of(ERROR_NOMBRE_NULL);
        }

        if(!Objects.isNull(canalDTO.getActivo()) && !estados.contains(String.valueOf(canalDTO.getActivo()).toUpperCase())){
            return Optional.of(ERROR_ACTIVO_INVALID);
        }
        if(Objects.isNull(canalDTO.getActivo()))
            canalDTO.setActivo(true);
        return Optional.empty();
    }

}
