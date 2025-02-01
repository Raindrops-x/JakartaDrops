package com.rain.jdee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<LineaCelular> carro;

    public Carro() {
        carro = new ArrayList<>();
    }

    public List<LineaCelular> getCarro() {
        return carro;
    }

    public void addLineaCelular(LineaCelular linea){
        if(linea == null){
            return;
        }
        if(carro.contains(linea)){
            Optional<LineaCelular> l = carro.stream().filter(linea::equals).findFirst();
            if(l.isPresent()){
                LineaCelular lineaobtenida = l.get();
                lineaobtenida.setCantidad(lineaobtenida.getCantidad()+1);
            }
        } else{
            carro.add(linea);
        }
    }

    public void vaciarCarrito(){
        carro.clear();
    }
}
