package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaVueloRepository extends JpaRepository<ReservaVueloModel, Long> {
   List<ReservaVueloModel> findByUsuario_Id(Long id);
   Optional<ReservaVueloModel> findByVuelo_Id(Long id);
   List<ReservaVueloModel> findByVuelo_NumeroDeVueloAndClase(Long id, String clase);
    List<ReservaVueloModel> findByVuelo_IdAndClase(Long id, String clase);
    boolean existsByUsuario_Id(Long id);
    boolean existsByVuelo_Id(Long id);
    boolean existsByVuelo_NumeroDeVuelo(Long numeroDeVuelo);
}
