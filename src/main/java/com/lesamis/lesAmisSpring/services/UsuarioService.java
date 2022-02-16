package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> obtenerPorDni(Long dni) {
        return usuarioRepository.findByDni(dni);
    }

    public Optional<UsuarioModel> obtenerPorUsuario(java.lang.String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Optional<UsuarioModel> obtenerUsuariosPorTipo(String Tipo) {
        return usuarioRepository.findByTipo(Tipo);
    }


    public UsuarioModel agregarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean existsById(Long id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByDni(Long dni){
        return usuarioRepository.existsByDni(dni);
    }

    public boolean existsByUsuario(java.lang.String usuario){
        return usuarioRepository.existsByUsuario(usuario);
    }

    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioModel> login(String usuario, String password){
        return usuarioRepository.findByUsuarioAndPassword(usuario,password);
    }

    public boolean existByUsuarioAndPassword(String usuario, String password){
        return usuarioRepository.existsByUsuarioAndPassword(usuario, password);
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
