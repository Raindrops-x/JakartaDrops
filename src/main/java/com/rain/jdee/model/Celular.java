package com.rain.jdee.model;

import java.time.LocalDate;
import java.util.Date;

public class Celular {
    private Integer id;
    private String nombre;
    private int precio;
    private Marca marca;
    private LocalDate fechaLanzamiento;

    public Celular() {
    }

    public Celular(Integer id, String nombre, int precio, Marca marca, LocalDate fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "|ID: "+this.id+" |Nombre: " + this.nombre + " |Precio: " + this.precio
                + " |Marca: " + this.marca.getNombre();
    }
}
