package com.rain.jdee.service;

import com.rain.jdee.model.Celular;
import com.rain.jdee.model.Marca;
import com.rain.jdee.repository.Repositorio;
import com.rain.jdee.repository.RepositorioCelularImp;
import com.rain.jdee.repository.RepositorioMarcaImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServicioProductoImp implements Service{
    private Repositorio<Celular> repositorioCelular;
    private Repositorio<Marca> repositorioMarca;

    public ServicioProductoImp(Connection cn) {
        repositorioCelular = new RepositorioCelularImp(cn);
        repositorioMarca = new RepositorioMarcaImp(cn);
    }

    @Override
    public List<Celular> listarCelulares() {
        try {
            return repositorioCelular.listar();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo listar los celulares: "+e);
        }
    }

    @Override
    public Optional<Celular> obtenerCelular(Integer id) {
        try {
            return Optional.ofNullable(repositorioCelular.buscar(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarCelular(Celular celular) {
        try {
            repositorioCelular.guardar(celular);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarCelular(Integer id) {
        try {
            repositorioCelular.borrar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Marca> listarMarca() {
        try {
            return repositorioMarca.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Marca> obtenerMarca(Integer id) {
        try {
            return Optional.ofNullable(repositorioMarca.buscar(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarMarca(Marca marca) {
        try {
            repositorioMarca.guardar(marca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarMarca(Integer id) {
        try {
            repositorioMarca.borrar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
