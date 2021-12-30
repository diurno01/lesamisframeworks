package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AgenciaRepository extends JpaRepository<AgenciaModel, Long> {
    Optional<AgenciaModel> findById(Long id);
    Optional<AgenciaModel> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
