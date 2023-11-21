package com.codigomorsa.mycrud.model;

public class series {
    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getVisto() {
        return visto;
    }

    public int getCelebridad() {
        return celebridad;
    }

    public final long id;

    public final String titulo;

    public final int episodios;


    public final int temporadas;


    public final int calificacion;

    public final String genero;

    public final String sinopsis;

    public final String visto;

    public final int celebridad;

    public series(long id, String titulo, int episodios, int temporadas, int calificacion, String genero, String sinopsis, String visto, int celebridad) {
        this.id = id;
        this.titulo = titulo;
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.calificacion = calificacion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.visto = visto;
        this.celebridad = celebridad;
    }
}
