package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public Optional<UsuarioModel> login(String usuario, String password){
        return loginRepository.findByUsuarioAndPassword(usuario,password);
    }

    public boolean existByUsuarioAndPassword(String usuario, String password){
        return loginRepository.existsByUsuarioAndPassword(usuario, password);
    }
}
