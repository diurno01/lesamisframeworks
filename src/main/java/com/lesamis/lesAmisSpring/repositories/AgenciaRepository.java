package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.AgenciaModel;
import com.lesamis.lesAmisSpring.models.SucursalModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AgenciaRepository extends CrudRepository<AgenciaModel, Long> {

}
