package org.acme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acme.utils.valids.ErrorMensaje;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoDTO {
    private String codigo;
    private Boolean ejecutado;
    private List<ErrorMensaje> errores;
}
