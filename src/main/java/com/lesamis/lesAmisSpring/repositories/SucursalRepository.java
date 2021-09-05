package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.SucursalModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends CrudRepository<SucursalModel, Long> {

}
