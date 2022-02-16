package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByDni(Long dni);
    Optional<UsuarioModel> findByTipo(String tipo);
    Optional<UsuarioModel> findByUsuario(String usuario);
    Optional<UsuarioModel> findByUsuarioAndPassword(String usuario, String password);
    boolean existsByUsuarioAndPassword(String usuario, String password);
    boolean existsByDni(Long dni);
    boolean existsByUsuario(String usuario);

}
