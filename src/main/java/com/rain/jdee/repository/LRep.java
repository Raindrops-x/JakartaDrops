package com.rain.jdee.repository;

import java.sql.SQLException;

public interface LRep<T> {
    T buscar(String username, String pass) throws SQLException;
    void registrar(String nombre, String username, String pass) throws SQLException;
}
