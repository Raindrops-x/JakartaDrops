package com.rain.jdee.model;

import java.util.Objects;

public class LineaCelular {
    private Celular celular;
    private int cantidad;

    public LineaCelular(Celular celular) {
        this.celular = celular;
        cantidad = 0;
    }

    public LineaCelular(Celular celular, int cantidad) {
        this.celular = celular;
        this.cantidad = cantidad;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int calcularPrecio(){
        return (this.celular.getPrecio()*cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LineaCelular that = (LineaCelular) o;
        return Objects.equals(celular.getId(), that.celular.getId()) &&
                Objects.equals(celular.getNombre(), that.celular.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(celular);
    }
}
