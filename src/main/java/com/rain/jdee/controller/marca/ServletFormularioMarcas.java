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

@WebServlet({"/marcas/formulario","/marcas/marcas_form", "/marcas/editar_marca"})
public class ServletFormularioMarcas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        Marca marca = new Marca();
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0;
        }
        if(id > 0){
            Optional<Marca> opcional = servicio.obtenerMarca(id);
            if(opcional.isPresent()){
                marca = opcional.get();
            }
        } else{
            marca.setNombre("");
            marca.setId(0);
        }
        req.setAttribute("marca",marca);
        getServletContext().getRequestDispatcher("/marcas_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre_marca");
        Integer id;
        try{
            id = Integer.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        if(nombre != null && !nombre.isBlank()){
            Marca marca = new Marca();
            marca.setId(id);
            marca.setNombre(nombre);
            servicio.guardarMarca(marca);
            resp.sendRedirect(req.getContextPath()+"/marcas");
        } else{
            String error_form_marca = "El campo de marca no puede estar vacio";
            req.setAttribute("error_form_marca",error_form_marca);
            getServletContext().getRequestDispatcher("/marcas_form.jsp").forward(req,resp);
        }
    }
}
