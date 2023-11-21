package com.codigomorsa.mycrud.model;

import java.util.Date;

public class Servicio {
    public final long id;

    public final Date fecha_ingreso;

    public final Date fecha_conclusion;

    public final String descripcion;

    public final int horas_invertidas;

    public final int costo_total_mano_de_obra;

    public final int costo_total_facturado;

    public long getId() {
        return id;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Date getFecha_conclusion() {
        return fecha_conclusion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHoras_invertidas() {
        return horas_invertidas;
    }

    public int getCosto_total_mano_de_obra() {
        return costo_total_mano_de_obra;
    }

    public int getCosto_total_facturado() {
        return costo_total_facturado;
    }

    public int getPorcentaje_utilidad() {
        return porcentaje_utilidad;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public final int porcentaje_utilidad;

    public final int vehiculo;


    public Servicio(long id, Date fechaIngreso, Date fechaConclusion, String descripcion, int horasInvertidas, int costoTotalManoDeObra, int costoTotalFacturado, int porcentajeUtilidad, int vehiculo) {
        this.id = id;
        this.fecha_ingreso = fechaIngreso;
        this.fecha_conclusion = fechaConclusion;
        this.descripcion = descripcion;
        this.horas_invertidas = horasInvertidas;
        this.costo_total_mano_de_obra = costoTotalManoDeObra;
        this.costo_total_facturado = costoTotalFacturado;
        this.porcentaje_utilidad = porcentajeUtilidad;
        this.vehiculo = vehiculo;
    }
}
