package com.codigomorsa.mycrud.model;

import java.sql.Date;

public class visualizacion {
    public long getId() {
        return id;
    }

    public int getVeces() {
        return veces;
    }

    public String getLugar() {
        return lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCine() {
        return cine;
    }

    public final long id;

    public final int veces;

    public final String lugar;


    public final Date fecha;

    public final int cine;


    public visualizacion(long id, int veces, String lugar, Date fecha, int cine) {
        this.id = id;
        this.veces = veces;
        this.lugar = lugar;
        this.fecha = fecha;
        this.cine = cine;
    }
}
