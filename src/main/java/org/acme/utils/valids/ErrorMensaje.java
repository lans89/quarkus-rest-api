package org.acme.utils.valids;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMensaje {
    private String codigo;
    private String mensaje;
    private String excepcionMensaje;
}
