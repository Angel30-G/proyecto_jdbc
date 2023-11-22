package com.codigomorsa.mycrud.model;

public class Cliente {
    public long getId() {
        return id;
    }

    public int getNumero_cliente() {
        return numero_cliente;
    }

    public int getCedula() {
        return cedula;
    }

    public String getTipo_cedula() {
        return tipo_cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getTaller() {
        return taller;
    }



    public final long id;

    public final int numero_cliente;

    public final int cedula;


    public final String tipo_cedula;


    public final int telefono;

    public final String email;


    public final int taller;



    public Cliente(long id, int numero_cliente, int cedula, String tipo_cedula, int telefono, String email, int taller) {
        this.id = id;
        this.numero_cliente = numero_cliente;
        this.cedula = cedula;
        this.tipo_cedula = tipo_cedula;
        this.telefono = telefono;
        this.email = email;
        this.taller = taller;

    }
}
