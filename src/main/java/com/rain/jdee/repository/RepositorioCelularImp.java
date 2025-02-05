package com.rain.jdee.repository;

import com.rain.jdee.model.Celular;
import com.rain.jdee.model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCelularImp implements Repositorio<Celular>{
    private Connection cn;

    public RepositorioCelularImp(Connection cn) {
        this.cn = cn;
    }

    @Override
    public List<Celular> listar() throws SQLException {
        List<Celular> celulares = new ArrayList<>();
        String sql = "select c.*,m.nombre as marca from celular c " +
                "inner join marca m on c.id_marca = m.id order by c.id asc;";
        try(Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql)){
            while(rs.next()){
                Celular celular = generarCelular(rs);
                celulares.add(celular);
            }
        }
        return celulares;
    }

    @Override
    public Celular buscar(Integer id) throws SQLException {
        Celular celular = null;
        String sql = "select c.*,m.nombre as marca from celular c " +
                "inner join marca m on c.id_marca = m.id where c.id=?";
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    celular = generarCelular(rs);
                }
            }
        }
        return celular;
    }

    @Override
    public void guardar(Celular celular) throws SQLException {
        if(celular == null){
            return;
        }
        String sql = "";
        if(celular.getId() != null || celular.getId()>0){
            sql = "update celular set nombre=?,precio=?,fechaLanzamiento=?,id_marca=? " +
                    "where id=?;";
        }
        if(celular.getId() ==null || celular.getId().equals(0)){
            sql = "insert into celular (nombre,precio,fechaLanzamiento,id_marca) " +
                    "values(?,?,?,?);";
        }
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1,celular.getNombre());
            ps.setInt(2,celular.getPrecio());
            ps.setDate(3, Date.valueOf(celular.getFechaLanzamiento()));
            ps.setInt(4,celular.getMarca().getId());
            if(celular.getId() != null && celular.getId()>0) {
                ps.setInt(5,celular.getId());
            }
            ps.executeUpdate();
        }
    }

    @Override
    public void borrar(Integer id) throws SQLException {
        String sql = "delete from celular where id=?;";
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    private static Celular generarCelular(ResultSet rs) throws SQLException {
        Celular celular = new Celular();
        celular.setId(rs.getInt("id"));
        celular.setNombre(rs.getString("nombre"));
        celular.setPrecio(rs.getInt("precio"));
        celular.setFechaLanzamiento(rs.getDate("fechaLanzamiento").toLocalDate());
        Marca marca = new Marca();
        marca.setId(rs.getInt("id_marca"));
        marca.setNombre(rs.getString("marca"));
        celular.setMarca(marca);
        return celular;
    }
}
