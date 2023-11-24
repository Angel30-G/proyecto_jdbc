package com.codigomorsa.mycrud.model;


public class Pieza {
    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCosto() {
        return costo;
    }


    public final long id;

    public final String codigo;

    public final String descripcion;


    public final int costo;




    public Pieza(long id, String codigo, String descripcion, int costo) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }
}
