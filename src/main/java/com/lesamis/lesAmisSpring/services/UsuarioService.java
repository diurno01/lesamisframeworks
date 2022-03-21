package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.ReservaHotelModel;
import com.lesamis.lesAmisSpring.models.ReservaVueloModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.ReservaHotelRepository;
import com.lesamis.lesAmisSpring.repositories.ReservaVueloRepository;
import com.lesamis.lesAmisSpring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ReservaVueloRepository reservaVueloRepository;

    @Autowired
    ReservaHotelRepository reservaHotelRepository;

    private UsuarioModel usuarioLogin;

    public UsuarioModel getUsuarioLogin() {
        if(this.usuarioLogin == null) this.usuarioLogin= new UsuarioModel();
        return usuarioLogin;
    }

    public void setUsuarioLogin(UsuarioModel usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

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

    public List<UsuarioModel> obtenerUsuariosPorTipo(java.lang.String Tipo) {
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

    public  Optional<ReservaVueloModel> obtenerReservasVuelo(Long id){
        return reservaVueloRepository.findByVuelo_Id(id);
    }

    public List<ReservaHotelModel> obtenerReservasHotel(Long id){
        return reservaHotelRepository.findByUsuario_Id(id);
    }

}
