package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Table(schema = "RECAUDOS", name = "TBL_MENSAJE")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    @Id
    private BigInteger id;
    @Column(name = "CODIGO", length = 5)
    private String codigo;
    @Column(name = "DESCRIPCION", length = 40)
    private String mensaje;
    @Column(name = "DESCRIPCION_TECNICA", length = 100)
    private String mensajeTecnico;
    @Column(name = "IDIOMA")
    private String idioma;
    @Column(name = "ESTADO")
    private Integer estado;
}
