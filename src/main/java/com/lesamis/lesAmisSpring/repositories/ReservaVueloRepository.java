package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaVueloRepository extends JpaRepository<ReservaVueloModel, Long> {
    Optional<ReservaVueloModel> findByIdUsuario(Long id);
}
