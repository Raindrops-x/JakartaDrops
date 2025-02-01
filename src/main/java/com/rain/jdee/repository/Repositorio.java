package com.rain.jdee.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    List<T> listar() throws SQLException;
    T buscar(Integer id) throws SQLException;
    void guardar(T t) throws SQLException;
    void borrar(Integer id) throws SQLException;
}
