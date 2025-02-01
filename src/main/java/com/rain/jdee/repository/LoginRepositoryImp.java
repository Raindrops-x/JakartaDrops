package com.rain.jdee.repository;

import com.rain.jdee.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepositoryImp implements LRep<Usuario>{
    private Connection cn;

    public LoginRepositoryImp(Connection cn) {
        this.cn = cn;
    }

    @Override
    public Usuario buscar(String username, String pass) throws SQLException {
        Usuario usuario = null;
        String sql = "select id,nombre from usuario where username=? and pass=?;";
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1,username);
            ps.setString(2,pass);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                }
            }
        }
        return usuario;
    }
}
