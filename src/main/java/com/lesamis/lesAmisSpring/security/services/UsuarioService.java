package com.lesamis.lesAmisSpring.security.services;

import com.lesamis.lesAmisSpring.security.models.Usuario;
import com.lesamis.lesAmisSpring.security.repositories.UsuarioRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepositorie usuarioRepositorie;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepositorie.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepositorie.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepositorie.existsByEmail(email);
    }

    public boolean existByDni(Long dni){
        return usuarioRepositorie.existsByDni(dni);
    }

    public void save(Usuario usuario){
        usuarioRepositorie.save(usuario);
    }
}
