package com.rain.jdee.controller.usuario;

import com.rain.jdee.model.Usuario;
import com.rain.jdee.service.ServiceLogin;
import com.rain.jdee.service.ServicioLogin;
import com.rain.jdee.util.LoginUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUtil utilidad = new LoginUtil();
        if(utilidad.validarUsuario(req).isPresent()){
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        } else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        ServiceLogin servicio = new ServicioLogin(cn);
        Optional<Usuario> usuario = servicio
                .obtenerUsuario(req.getParameter("username"),
                                req.getParameter("password"));
        try{
            if(usuario.isPresent()){
                LoginUtil utilidad = new LoginUtil();
                utilidad.activarSesionUsuario(req,usuario.get());
                getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
            } else{
                String error = "Las credenciales no son correctas";
                req.setAttribute("error_login",error);
                getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        } catch (Exception e){
            String error = "Error al conectar con la base de datos";
            req.setAttribute("error_login",error);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
