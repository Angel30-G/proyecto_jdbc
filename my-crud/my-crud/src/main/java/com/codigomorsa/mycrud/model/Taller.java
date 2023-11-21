package com.codigomorsa.mycrud.model;

public class Taller {

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCanton() {
        return canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getOtras_señas() {
        return otras_señas;
    }

    public int getCosto_operacion() {
        return costo_operacion;
    }

    public int getHoras_de_trabajo() {
        return horas_de_trabajo;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public final long id;

    public final String nombre;

    public final String provincia;

    public final String canton;

    public final String distrito;

    public final String otras_señas;

    public final int costo_operacion;

    public final int horas_de_trabajo;

    public final int telefono;

    public final String nombre_usuario;

    public final String email;

    public final String contraseña;


    public Taller(long id, String nombre, String provincia, String canton, String distrito, String otrasSeñas, int costoOperacion, int horasDeTrabajo, int telefono, String nombreUsuario, String email, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        otras_señas = otrasSeñas;
        costo_operacion = costoOperacion;
        horas_de_trabajo = horasDeTrabajo;
        this.telefono = telefono;
        nombre_usuario = nombreUsuario;
        this.email = email;
        this.contraseña = contraseña;
    }
}
