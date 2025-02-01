package com.rain.jdee.filter;

import com.rain.jdee.model.Usuario;
import com.rain.jdee.util.LoginUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/logout","/logout.html", "/celulares/*", "/marcas/*"})
public class FiltroLogin implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginUtil utilidad = new LoginUtil();
        Optional<Usuario> usuario = utilidad.validarUsuario((HttpServletRequest) request);
        if(usuario.isPresent()){
            chain.doFilter(request, response);
        } else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usted no esta loggeado!");
        }
    }
}
