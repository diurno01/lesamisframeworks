package com.lesamis.lesAmisSpring.security.models;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private String nombreUsuario;
    private String password;
    private Long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Collection<? extends GrantedAuthority> autorities;

    public UsuarioPrincipal(String nombreUsuario, String password, Long dni, String nombre, String apellido, String direccion, String telefono, String email, Collection<? extends GrantedAuthority> autorities) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.autorities = autorities;
    }
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol-> new SimpleGrantedAuthority(
                        rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombreUsuario(),
                usuario.getPassword(),
                usuario.getDni(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getEmail(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
