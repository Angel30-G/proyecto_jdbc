package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.celebridad;
import com.codigomorsa.mycrud.model.cine;
import com.codigomorsa.mycrud.repositories.celebridadRepository;
import com.codigomorsa.mycrud.repositories.cineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cineService {
    private final cineRepository repository;

    public cineService(cineRepository repository){
        this.repository = repository;
    }

    public List<cine> getAllCine(){
        return repository.getAllCine();
    }


    public long createCine(cine newCine) {
        return repository.createCine(newCine);
    }
}
