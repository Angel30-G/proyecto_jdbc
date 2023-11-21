package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Pieza;
import com.codigomorsa.mycrud.repositories.PiezaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiezaService {
    private final PiezaRepository repository;

    public PiezaService(PiezaRepository repository){
        this.repository = repository;
    }

    public List<Pieza> getAllPiezas(){
        return repository.getAllPiezas();
    }


    public long createPieza(Pieza newPieza) {
        return repository.createPieza(newPieza);
    }
}
