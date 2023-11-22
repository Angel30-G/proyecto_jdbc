package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Taller;
import com.codigomorsa.mycrud.repositories.TallerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerService {
    private final TallerRepository repository;

    public TallerService(TallerRepository repository){
        this.repository = repository;
    }

    public List<Taller> getAllTaller(){
        return repository.getAllTaller();
    }


    public long createTaller(Taller newTaller) {
        return repository.createTaller(newTaller);
    }
}
