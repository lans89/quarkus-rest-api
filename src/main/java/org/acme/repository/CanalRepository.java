package org.acme.repository;

import org.acme.entity.Canal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CanalRepository extends JpaRepository<Canal, String> {
    @Query("select c from Canal c where c.estado = 0")
    List<Canal> listarCanalesActivos();

    @Query("select c from Canal c where c.id = :id")
    Optional<Canal> obtenerCanalInfo(@Param("id") String id);
}
