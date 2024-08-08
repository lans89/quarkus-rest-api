package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(schema = "RECAUDOS", name = "TBL_CANAL")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Canal {
    @Id
    private String id;
    @Column(name = "nombre", length = 30)
    private String nombre;
    @Column(name = "estado")
    private Integer estado;
}
