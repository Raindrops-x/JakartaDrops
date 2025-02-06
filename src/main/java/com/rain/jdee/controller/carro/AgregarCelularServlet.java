package com.rain.jdee.controller.carro;

import com.rain.jdee.model.Carro;
import com.rain.jdee.model.Celular;
import com.rain.jdee.model.LineaCelular;
import com.rain.jdee.service.Service;
import com.rain.jdee.service.ServicioProductoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carrito/agregar_celular")
public class AgregarCelularServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            Optional<Celular> celular = servicio.obtenerCelular(id);
            if(celular.isPresent()){
                HttpSession sesion = req.getSession();
                Carro carro = (Carro) sesion.getAttribute("carro");
                carro.addLineaCelular(new LineaCelular(celular.get(),1));
                resp.sendRedirect(req.getContextPath()+"/carrito/ver_mi_carrito");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
