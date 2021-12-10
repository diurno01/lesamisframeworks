package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNombreAndApellido(String nombre,String apellido);

}
