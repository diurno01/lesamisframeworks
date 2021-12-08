package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.VueloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<VueloModel, Long> {
}
