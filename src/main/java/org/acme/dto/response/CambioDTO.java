package org.acme.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioDTO {
    private LocalDate fecha;
    private String deMoneda;
    private String deMonedaNombre;
    private String deMonedaSimbolo;
    private String aMoneda;
    private String aMonedaNombre;
    private String aMonedaSimbolo;
    private BigDecimal tasaCambioVenta;
    private BigDecimal tasaCambioCompra;
}
