package org.acme.repository;

import org.acme.entity.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Optional;

public interface CambioRepository extends JpaRepository<Cambio, BigInteger> {

    @Query("SELECT c FROM Cambio c WHERE c.monedaOrigen = :monedaOrigen and c.monedaDestino = :monedaDestino and c.fecha = :fecha")
    Optional<Cambio> obtenerTasaCambio(
            @Param("monedaOrigen")String monedaOrigen,
            @Param("monedaDestino")String monedaDestino,
            @Param("fecha")LocalDate fecha);
}
