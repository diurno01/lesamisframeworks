package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.Tipo;
import com.lesamis.lesAmisSpring.models.UsuarioModel2;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class UsuarioService2 {

//    @Autowired
    UsuarioRepository2 usuarioRepository;

    public List<UsuarioModel2> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel2> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel2> obtenerPorDni(Long dni) {
        return usuarioRepository.findByDni(dni);
    }

    public Optional<UsuarioModel2> obtenerPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Optional<UsuarioModel2> obtenerUsuariosPorTipo(Tipo Tipo) {
        return usuarioRepository.findByTipo(Tipo);
    }


    public UsuarioModel2 agregarUsuario(UsuarioModel2 usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean existsById(Long id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByDni(Long dni){
        return usuarioRepository.existsByDni(dni);
    }
    public boolean existsByUsuario(String usuario){
        return usuarioRepository.existsByUsuario(usuario);
    }

    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
//    public boolean eliminarUsuario(Long id) {
//        try {
//            usuarioRepository.deleteById(id);
//            return true;
//        } catch (Exception err) {
//            return false;
//        }
//    }
}
