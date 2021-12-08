package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.ReservaVuelaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaVueloRepository extends JpaRepository<ReservaVuelaModel, Long> {
}
