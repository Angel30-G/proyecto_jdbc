package com.codigomorsa.mycrud.model;

public class celebridad {
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public final long id;

    public final String nombre;

    public final String rol;

    public celebridad(long id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }
}
