package com.rain.jdee.controller.celular;

import com.rain.jdee.model.Celular;
import com.rain.jdee.service.Service;
import com.rain.jdee.service.ServicioProductoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet({"/celulares","/celulares.html"})
public class ServletCelulares extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        List<Celular> celulares = servicio.listarCelulares();
        req.setAttribute("celulares",celulares);
        getServletContext().getRequestDispatcher("/celulares.jsp").forward(req,resp);
    }
}
