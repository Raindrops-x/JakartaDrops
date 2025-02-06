package com.rain.jdee.listener;

import com.rain.jdee.model.Carro;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class CarroListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession sesion = se.getSession();
        if(sesion != null){
            Carro carro = new Carro();
            sesion.setAttribute("carro", carro);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession sesion = se.getSession();
        sesion.removeAttribute("carro");
    }
}
