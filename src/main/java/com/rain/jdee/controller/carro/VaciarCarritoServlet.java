package com.rain.jdee.controller.carro;

import com.rain.jdee.model.Carro;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/carrito/vaciar_carrito")
public class VaciarCarritoServlet extends HttpServlet {

    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        carro.vaciarCarrito();
        resp.sendRedirect(req.getContextPath()+"/carrito/ver_mi_carrito");
    }
}
