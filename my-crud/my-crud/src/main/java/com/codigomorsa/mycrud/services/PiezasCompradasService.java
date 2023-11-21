package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.model.Taller;
import com.codigomorsa.mycrud.repositories.PiezasCompradasRepository;
import com.codigomorsa.mycrud.repositories.TallerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiezasCompradasService {
    private final PiezasCompradasRepository repository;

    public PiezasCompradasService(PiezasCompradasRepository repository){
        this.repository = repository;
    }

    public List<Piezas_Compradas> getAllPiezasCompradas(){
        return repository.getAllPiezasCompradas();
    }


    public long createPiezasCompradas(Piezas_Compradas newPiezasCompradas) {
        return repository.createPiezasCompradas(newPiezasCompradas);
    }
}
