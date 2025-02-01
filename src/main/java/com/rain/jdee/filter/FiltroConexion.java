package com.rain.jdee.filter;

import com.rain.jdee.util.ConexionDb;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class FiltroConexion implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try(Connection cn = ConexionDb.getConexion()){
            if(cn.getAutoCommit()){
                cn.setAutoCommit(false);
            }
            try{
                req.setAttribute("conexion",cn);
                chain.doFilter(req,res);
                cn.commit();
            }catch (SQLException e){
                cn.rollback();
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
