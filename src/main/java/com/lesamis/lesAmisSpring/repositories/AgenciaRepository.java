package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgenciaRepository extends JpaRepository<AgenciaModel, Long> {

}
