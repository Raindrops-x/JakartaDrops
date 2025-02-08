package com.rain.jdee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDbOld {
    private static String url = System.getenv("mysql_url");
    private static String username = System.getenv("mysql_usuario");
    private static String password = System.getenv("mysql_pass");

    public static Connection getConexion() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver no encontrado!: "  + e.getMessage());
        }
        return DriverManager.getConnection(url,username,password);
    }
}
