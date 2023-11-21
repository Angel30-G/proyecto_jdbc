package com.codigomorsa.mycrud.model;


public class pelicula {

    public final long id;

    public final String titulo;

    public final String sinopsis;


    public final String visto;


    public final String genero;

    public final int nota;



    public final int visualizacion;


    public final int celebridad;

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getVisto() {
        return visto;
    }

    public String getGenero() {
        return genero;
    }

    public int getNota() {
        return nota;
    }

    public int getVisualizacion() {
        return visualizacion;
    }

    public int getCelebridad() {
        return celebridad;
    }



    public pelicula(long id, String titulo, String sinopsis, String visto, String genero, int nota, int visualizacion, int celebridad) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.visto = visto;
        this.genero = genero;
        this.nota = nota;
        this.visualizacion = visualizacion;
        this.celebridad = celebridad;
    }

}

