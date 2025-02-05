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
import java.util.Optional;

@WebServlet("/marcas/eliminar_marca")
public class ServletEliminarMarca extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            Optional<Marca> marca = servicio.obtenerMarca(id);
            if(marca.isPresent()){
                servicio.eliminarMarca(id);
                getServletContext().getRequestDispatcher("/marcas.html").forward(req,resp);
            } else{
                String error = "El numero de la marca no existe";
                req.setAttribute("error_delete",error);
                getServletContext().getRequestDispatcher("/marcas.html").forward(req,resp);
            }
        } catch (NumberFormatException e){
            String error = "El id enviado no es un numero";
            req.setAttribute("error_delete",error);
            getServletContext().getRequestDispatcher("/marcas.html").forward(req,resp);
        }

    }
}
