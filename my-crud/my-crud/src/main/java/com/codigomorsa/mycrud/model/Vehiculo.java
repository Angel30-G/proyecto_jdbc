package com.codigomorsa.mycrud.model;

public class Vehiculo {
    public long getId() {
        return id;
    }

    public int getNumero_placa() {
        return numero_placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño_fabricacion() {
        return año_fabricacion;
    }

    public String getVIN() {
        return VIN;
    }

    public int getCliente() {
        return cliente;
    }
    public final long id;

    public final int numero_placa;

    public final String marca;



    public final String modelo;

    public final int año_fabricacion;

    public final String VIN;

    public final int cliente;


    public Vehiculo(long id, int numero_placa, String marca, String modelo, int año_fabricacion, String VIN, int cliente) {
        this.id = id;
        this.numero_placa = numero_placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año_fabricacion = año_fabricacion;
        this.VIN = VIN;
        this.cliente = cliente;
    }
}
