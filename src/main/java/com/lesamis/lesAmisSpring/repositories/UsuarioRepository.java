package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByTipo(Integer tipo);


}
