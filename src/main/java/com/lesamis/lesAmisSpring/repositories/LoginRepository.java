package com.lesamis.lesAmisSpring.repositories;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByUsuarioAndPassword(String usuario, String password);
    Optional<UsuarioModel> findByUsuario(String usuario);
    boolean existsByUsuarioAndPassword(String usuario, String password);
    boolean existsByUsuario(String usuario);
}
