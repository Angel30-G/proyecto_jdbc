package com.codigomorsa.mycrud.model;

public class cine {
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public final long id;

    public final String nombre;

    public final String ubicacion;

    public cine(long id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
}
