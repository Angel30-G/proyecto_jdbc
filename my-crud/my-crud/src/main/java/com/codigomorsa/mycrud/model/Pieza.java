package com.codigomorsa.mycrud.model;

import java.sql.Date;

public class Pieza {
    public long getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCosto() {
        return costo;
    }


    public final long id;

    public final int codigo;

    public final String descripcion;


    public final int costo;




    public Pieza(long id, int codigo, String descripcion, int costo) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }
}
