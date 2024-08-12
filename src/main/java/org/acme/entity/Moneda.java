package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(schema = "RECAUDOS", name = "TBL_MONEDA")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Moneda {
    @Id
    @Column(name = "ID_MONEDA")
    private String id;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "SIMBOLO")
    private String simbolo;
    @Column(name = "NOMBRE")
    private String nombre;
}
