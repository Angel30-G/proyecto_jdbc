package com.codigomorsa.mycrud.controllers;


import com.codigomorsa.mycrud.services.peliculaService;
import com.codigomorsa.mycrud.model.pelicula;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class peliculaController {

    private final peliculaService peliculaService;

    public peliculaController(peliculaService peliculaService){
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public List<pelicula> getAllPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @PostMapping("/peliculas")
    public long createPelicula(@RequestBody pelicula newPelicula) {
        return peliculaService.createPelicula(newPelicula);
    }
}
