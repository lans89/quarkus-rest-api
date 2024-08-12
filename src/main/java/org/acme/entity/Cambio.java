package org.acme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Table(schema = "RECAUDOS", name = "TBL_CAMBIO")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "FECHA")
    private LocalDate fecha;
    @Column(name = "TASA_CAMBIO_VENTA")
    private BigDecimal tasaCambioVenta;
    @Column(name = "TASA_CAMBIO_COMPRA")
    private BigDecimal tasaCambioCompra;
    @Column(name = "ID_MONEDA_ORIGEN")
    private String monedaOrigen;
    @Column(name = "ID_MONEDA_DESTINO")
    private String monedaDestino;
}
