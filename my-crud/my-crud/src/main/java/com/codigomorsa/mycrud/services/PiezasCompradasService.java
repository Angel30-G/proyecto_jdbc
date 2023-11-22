package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.repositories.PiezasCompradasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiezasCompradasService {
    private final PiezasCompradasRepository repository;

    public PiezasCompradasService(PiezasCompradasRepository repository){
        this.repository = repository;
    }

    public List<Piezas_Compradas> getAllPiezasC(){
        return repository.getAllPiezasC();
    }


    public long createPiezasC(Piezas_Compradas newPiezasC) {
        return repository.createPiezasCompradas(newPiezasC);
    }
}
