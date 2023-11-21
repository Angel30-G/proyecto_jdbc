package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.celebridad;
import com.codigomorsa.mycrud.repositories.celebridadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class celebridadService {
    private final celebridadRepository repository;

    public celebridadService(celebridadRepository repository){
        this.repository = repository;
    }

    public List<celebridad> getAllCelebridades(){
        return repository.getAllCelebridades();
    }


    public long createCelebridad(celebridad newCelebridad) {
        return repository.createCelebridad(newCelebridad);
    }
}
