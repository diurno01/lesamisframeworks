package com.lesamis.lesAmisSpring.security.repositories;

import com.lesamis.lesAmisSpring.security.enums.RolNombre;
import com.lesamis.lesAmisSpring.security.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorie extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
