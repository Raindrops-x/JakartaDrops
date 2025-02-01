package com.rain.jdee.repository;

import java.sql.SQLException;

public interface LRep<T> {
    T buscar(String username, String pass) throws SQLException;
}
