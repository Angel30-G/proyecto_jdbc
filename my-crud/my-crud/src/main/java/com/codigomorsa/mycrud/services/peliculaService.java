package com.codigomorsa.mycrud.services;


import com.codigomorsa.mycrud.model.pelicula;
import com.codigomorsa.mycrud.repositories.peliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peliculaService {
    private final peliculaRepository repository;

    public peliculaService(peliculaRepository repository){
        this.repository = repository;
    }

    public List<pelicula> getAllPeliculas(){
        return repository.getAllPeliculas();
    }


    public long createPelicula(pelicula newPelicula) {
        return repository.createPelicula(newPelicula);
    }
}
