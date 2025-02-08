package com.rain.jdee.controller.carro;

import com.rain.jdee.model.Carro;
import com.rain.jdee.model.Celular;
import com.rain.jdee.model.LineaCelular;
import com.rain.jdee.service.Service;
import com.rain.jdee.service.ServicioProductoImp;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carrito/quitar_celular")
public class ServletQuitarElemento extends HttpServlet {

    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            if(id > 0){
                carro.quitarLinea(id);
                resp.sendRedirect(req.getContextPath()+"/carrito/ver_mi_carrito");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
