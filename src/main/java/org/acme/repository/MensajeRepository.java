package org.acme.repository;

import org.acme.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, BigInteger> {

    @Query("select m from Mensaje m where m.estado = 0")
    List<Mensaje> listarMensajesActivos();

}
