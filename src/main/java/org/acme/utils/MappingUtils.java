package org.acme.utils;

import jakarta.inject.Singleton;
import org.acme.dto.response.CanalDTO;
import org.acme.entity.Canal;

@Singleton
public class MappingUtils {

    public CanalDTO convertirDe(Canal canal){
        return CanalDTO.builder()
                .id(canal.getId())
                .nombre(canal.getNombre())
                .activo(canal.getEstado()==0).build();
    }

    public Canal convertirDe(CanalDTO canalDTO){
        return Canal.builder()
                .id(canalDTO.getId())
                .nombre(canalDTO.getNombre())
                .estado(canalDTO.getActivo()?0:1).build();
    }

}
