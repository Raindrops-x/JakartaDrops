package com.rain.jdee.controller;

import com.rain.jdee.util.LoginUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/logout","/logout.html"})
public class ServletLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LoginUtil utilidad = new LoginUtil();
        utilidad.cerrarSesionUsuario(req);
        getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}
