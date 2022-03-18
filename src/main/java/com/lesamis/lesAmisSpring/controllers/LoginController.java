package com.lesamis.lesAmisSpring.controllers;

import com.lesamis.lesAmisSpring.models.LoginModel;
import com.lesamis.lesAmisSpring.models.MensajeModel;
import com.lesamis.lesAmisSpring.models.UsuarioModel;
import com.lesamis.lesAmisSpring.services.LoginService;
import com.lesamis.lesAmisSpring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/check")
    public ResponseEntity<UsuarioModel> login(@RequestBody LoginModel loginModel){
        if(!usuarioService.existByUsuarioAndPassword(loginModel.getUsuario(), loginModel.getPassword()))
            return new ResponseEntity(new MensajeModel("Este usuario no existe, vuelva a intentar."), HttpStatus.NOT_FOUND);
        UsuarioModel user = usuarioService.login(loginModel.getUsuario(), loginModel.getPassword()).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }


}
