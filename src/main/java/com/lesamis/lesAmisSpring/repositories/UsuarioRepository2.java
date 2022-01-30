package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.Tipo;
import com.lesamis.lesAmisSpring.models.UsuarioModel2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@Repository
public interface UsuarioRepository2 extends JpaRepository<UsuarioModel2, Long> {

    Optional<UsuarioModel2> findByDni(Long dni);
    Optional<UsuarioModel2> findByTipo(Tipo tipo);
    Optional<UsuarioModel2> findByUsuario(String Usuario);
    boolean existsByDni(Long dni);
    boolean existsByUsuario(String usuario);

}
