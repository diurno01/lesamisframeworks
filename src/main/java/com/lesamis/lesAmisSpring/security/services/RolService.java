package com.lesamis.lesAmisSpring.security.services;

import com.lesamis.lesAmisSpring.security.enums.RolNombre;
import com.lesamis.lesAmisSpring.security.models.Rol;
import com.lesamis.lesAmisSpring.security.repositories.RolRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepositorie rolRepositorie;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepositorie.findByRolNombre(rolNombre);
    }
}
