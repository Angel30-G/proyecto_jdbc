package com.codigomorsa.mycrud.model;

public class Piezas_Compradas {
    public final long id;

    public final String codigo;

    public final int cantidad;

    public final int costo_total;

    public final int pieza;

    public final int servicio;

    public Piezas_Compradas(long id, String codigo, int cantidad, int costoTotal, int pieza, int servicio) {
        this.id = id;
        this.codigo = codigo;
        this.cantidad = cantidad;
        costo_total = costoTotal;
        this.pieza = pieza;
        this.servicio = servicio;
    }


    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCosto_total() {
        return costo_total;
    }

    public int getPieza() {
        return pieza;
    }

    public int getServicio() {
        return servicio;
    }


}
