package com.rain.jdee.repository;

import com.rain.jdee.model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMarcaImp implements Repositorio<Marca>{
    private Connection cn;

    public RepositorioMarcaImp(Connection cn) {
        this.cn = cn;
    }
    @Override
    public List<Marca> listar() throws SQLException {
        List<Marca> marcas = new ArrayList<>();
        String sql = "select * from marca;";
        try(Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql)){
            while(rs.next()){
                Marca marca = generarMarca(rs);
                marcas.add(marca);
            }
        }
        return marcas;
    }

    @Override
    public Marca buscar(Integer id) throws SQLException {
        Marca marca = null;
        String sql = "select * from marca where id=?;";
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    marca = generarMarca(rs);
                }
            }
        }
        return marca;
    }

    @Override
    public void guardar(Marca marca) throws SQLException {
        if(marca == null){
            return;
        }
        String sql = "";
        if(marca.getId() != null || marca.getId()>0){
            sql = "update marca set nombre=? where id=?;";
        }
        if(marca.getId() == null || marca.getId().equals(0)){
            sql = "insert into marca (nombre) values (?);";
        }
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1,marca.getNombre());
            if(marca.getId() != null || marca.getId()>0){
                ps.setInt(2,marca.getId());
            }
            ps.executeUpdate();
        }
    }

    @Override
    public void borrar(Integer id) throws SQLException {
        String sql = "delete from marca where id=?;";
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    private static Marca generarMarca(ResultSet rs) throws SQLException {
        Marca marca = new Marca();
        marca.setId(rs.getInt("id"));
        marca.setNombre(rs.getString("nombre"));
        return marca;
    }
}
