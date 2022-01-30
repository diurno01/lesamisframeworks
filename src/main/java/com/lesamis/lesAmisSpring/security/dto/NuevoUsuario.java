package com.lesamis.lesAmisSpring.security.dto;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {

    //10:53 cap 5
    private String nombreUsuario;
    private String password;
    private Long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Set<String> roles = new HashSet<>();
}
