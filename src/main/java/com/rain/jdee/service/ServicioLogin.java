package com.rain.jdee.service;

import com.rain.jdee.model.Usuario;
import com.rain.jdee.repository.LRep;
import com.rain.jdee.repository.LoginRepositoryImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class ServicioLogin implements ServiceLogin{
    private LRep<Usuario> repositorio;

    public ServicioLogin(Connection cn) {
        repositorio = new LoginRepositoryImp(cn);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(String username, String pass) {
        try {
            return Optional.ofNullable(repositorio.buscar(username,pass));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registrarUsuario(String nombre, String usuario, String pass) {
        try{
            repositorio.registrar(nombre,usuario,pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
