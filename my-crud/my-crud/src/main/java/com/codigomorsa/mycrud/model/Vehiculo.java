package com.codigomorsa.mycrud.model;

public class Vehiculo {


    public Vehiculo(long id, String numeroPlaca, String marca, String modelo, int anofabricacion, String vin, int cliente) {
        this.id = id;
        numero_placa = numeroPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.anofabricacion = anofabricacion;
        VIN = vin;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public String getNumero_placa() {
        return numero_placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño_fabricacion() {
        return anofabricacion;
    }

    public String getVIN() {
        return VIN;
    }

    public int getCliente() {
        return cliente;
    }

    public final long id;

    public final String numero_placa;

    public final String marca;



    public final String modelo;

    public final int anofabricacion;

    public final String VIN;

    public final int cliente;





}
