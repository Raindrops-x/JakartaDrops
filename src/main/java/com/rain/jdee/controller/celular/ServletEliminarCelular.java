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
import java.util.Optional;

@WebServlet("/celulares/eliminar_celular")
public class ServletEliminarCelular extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            Optional<Celular> celular = servicio.obtenerCelular(id);
            if(celular.isPresent()){
                servicio.eliminarCelular(celular.get().getId());
                getServletContext().getRequestDispatcher("/celulares").forward(req,resp);
            } else{
                resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE
                        ,"El id no esta disponible en la base de datos!");
            }
        }catch (NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE
                    ,"El id no es valido!");
        }

    }
}
