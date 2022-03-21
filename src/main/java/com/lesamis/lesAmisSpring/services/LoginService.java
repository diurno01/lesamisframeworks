package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.LoginModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    private UsuarioModel usuarioLogin;

    public Optional<UsuarioModel> login(String usuario, String password){
        return loginRepository.findByUsuarioAndPassword(usuario,password);
    }

    public UsuarioModel login(String usuario){
        return loginRepository.findByUsuario(usuario).get();
    }

    public boolean existByUsuarioAndPassword(String usuario, String password){
        return loginRepository.existsByUsuarioAndPassword(usuario, password);
    }

    public boolean existByUsuario(String usuario){
        return loginRepository.existsByUsuario(usuario);
    }

    public UsuarioModel getUsuarioLogin() {
        if(this.usuarioLogin == null) this.usuarioLogin= new UsuarioModel();
        return usuarioLogin;
    }

    public void setUsuarioLogin(UsuarioModel usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }
}
