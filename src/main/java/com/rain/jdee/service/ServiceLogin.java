package com.rain.jdee.service;

import com.rain.jdee.model.Usuario;

import java.util.Optional;

public interface ServiceLogin {
    Optional<Usuario> obtenerUsuario(String username, String pass);
    void registrarUsuario(String nombre, String usuario, String pass);
}
