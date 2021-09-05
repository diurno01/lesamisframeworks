package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<UsuarioModel> obtenerPorTipo(Integer Tipo) {
        return usuarioRepository.findByTipo(Tipo);
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
}
