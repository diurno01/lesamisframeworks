package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.VueloModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends CrudRepository<VueloModel, Long> {
}
