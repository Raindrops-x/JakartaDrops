package com.rain.jdee.util;

import com.rain.jdee.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginUtil {
    public Optional<Usuario> validarUsuario(HttpServletRequest req){
        HttpSession sesion = req.getSession();
        if(sesion != null){
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            return Optional.ofNullable(usuario);
        }
        return Optional.empty();
    }

    public void activarSesionUsuario(HttpServletRequest req, Usuario usuario){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuario",usuario);
    }

    public void cerrarSesionUsuario(HttpServletRequest req){
        HttpSession sesion = req.getSession(false);
        if(sesion != null){
            sesion.removeAttribute("usuario");
            sesion.invalidate();
        }
    }
}
