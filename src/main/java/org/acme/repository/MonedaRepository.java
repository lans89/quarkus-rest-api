package org.acme.repository;

import org.acme.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MonedaRepository extends JpaRepository<Moneda, String> {

    @Query("SELECT m FROM Moneda m WHERE m.id = :moneda")
    Optional<Moneda> obtenerInfoMoneda(@Param("moneda") String moneda);

}
