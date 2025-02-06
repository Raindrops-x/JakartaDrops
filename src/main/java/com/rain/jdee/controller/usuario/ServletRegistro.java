package com.rain.jdee.controller.usuario;

import com.rain.jdee.service.Service;
import com.rain.jdee.service.ServiceLogin;
import com.rain.jdee.service.ServicioLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/registro","/registro.html"})
public class ServletRegistro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registro.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errores = new ArrayList<>();
        String nombre = req.getParameter("nombre").trim();
        String usuario = req.getParameter("usuario_name").trim();
        String pass = req.getParameter("usuario_pass").trim();
        String pass_sec = req.getParameter("pass_repeat".trim());
        if(nombre.isEmpty()){
            errores.add("El nombre no puede estar vacio");
        }
        if(usuario.isEmpty()){
            errores.add("El usuario no puede estar vacio");
        }
        if(pass.isEmpty()){
            errores.add("La contraseña no puede estar vacio");
        }
        if(pass_sec.isEmpty()){
            errores.add("La confirmación de contraseña no puede estar vacio");
        }
        if(errores.isEmpty()){
            if(pass.equals(pass_sec)){
                Connection cn = (Connection) req.getAttribute("conexion");
                ServiceLogin service = new ServicioLogin(cn);
                service.registrarUsuario(nombre,usuario,pass);
                req.setAttribute("sugerencia","Ingrese nuevamente sus nuevas credenciales!");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
            } else{
                errores.add("Las contraseñas no coinciden!");
                req.setAttribute("errores",errores);
                getServletContext().getRequestDispatcher("/registro.jsp").forward(req,resp);
            }
        } else{
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/registro.jsp").forward(req,resp);
        }
    }
}
