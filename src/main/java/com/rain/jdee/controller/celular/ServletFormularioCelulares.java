package com.rain.jdee.controller.celular;

import com.rain.jdee.model.Celular;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet({"/celulares/formulario","/celulares/celular_form","/celulares/editar_celular"})
public class ServletFormularioCelulares extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        List<Marca> marcas = servicio.listarMarca();
        Celular celular = new Celular();
        celular.setMarca(new Marca());
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0;
        }
        if(id > 0){
            Optional<Celular> opcional = servicio.obtenerCelular(id);
            if(opcional.isPresent()){
                celular = opcional.get();
            }
        }

        req.setAttribute("celular",celular);
        req.setAttribute("marcas",marcas);
        getServletContext().getRequestDispatcher("/celular_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Connection cn = (Connection) req.getAttribute("conexion");
        Service servicio = new ServicioProductoImp(cn);
        List<String> errores = new ArrayList<>();
        //Celular
        String nombre = req.getParameter("nombre_celular");
        if(nombre == null || nombre.isBlank()){
            errores.add("El nombre no puede estar vacio");
        }
        Integer precio;
        try{
            precio = Integer.parseInt(req.getParameter("precio"));
        } catch (NumberFormatException e){
            precio = 0;
        }
        if(precio == 0){
            errores.add("El precio introducido no es un numero");
        }
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0;
        }
        String fecha = req.getParameter("fecha");
        LocalDate lanzamiento = null;
        try{
            lanzamiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e){
            errores.add("fecha vacia");
        }
        Integer m;
        try{
            m = Integer.parseInt(req.getParameter("marca"));
        } catch (NumberFormatException e) {
            m = 0;
        }
        if(m == 0){
            errores.add("La marca ingresada no es valida");
        }
        Celular celular = new Celular();
        celular.setId(id);
        celular.setNombre(nombre);
        celular.setPrecio(precio);
        celular.setFechaLanzamiento(lanzamiento);
        Marca marca = new Marca();
        marca.setId(m);
        celular.setMarca(marca);
        if(errores.isEmpty()){
                servicio.guardarCelular(celular);
                resp.sendRedirect(req.getContextPath()+"/celulares");
        } else{
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/celular_form.jsp").forward(req,resp);
        }
    }
}
