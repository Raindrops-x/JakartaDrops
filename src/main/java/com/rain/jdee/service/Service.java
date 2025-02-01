package com.rain.jdee.service;

import com.rain.jdee.model.Celular;
import com.rain.jdee.model.Marca;

import java.util.List;
import java.util.Optional;

public interface Service {
    //CELULARES
    List<Celular> listarCelulares();
    Optional<Celular> obtenerCelular(Integer id);
    void guardarCelular(Celular celular);
    void eliminarCelular(Integer id);
    //MARCAS
    List<Marca> listarMarca();
    Optional<Marca> obtenerMarca(Integer id);
    void guardarMarca(Marca marca);
    void eliminarMarca(Integer id);
}
