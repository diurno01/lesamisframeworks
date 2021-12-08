package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.VueloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<VueloModel, Long> {
    Optional<VueloModel> findByNumeroDeVuelo(Long numeroDeVuelo);
    boolean existsByNumeroDeVuelo(Long numeroDeVuelo);
}
