package com.rain.jdee.controller.marca;

import com.rain.jdee.model.Marca;
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

@WebServlet({"/marcas","/marcas.html"})
public class ServletMarcas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        List<Marca> marcas = servicio.listarMarca();
        req.setAttribute("marcas",marcas);
        getServletContext().getRequestDispatcher("/marcas.jsp").forward(req,resp);
    }
}
