package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.series;
import com.codigomorsa.mycrud.repositories.seriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class seriesService {
    private final seriesRepository repository;

    public seriesService(seriesRepository repository){
        this.repository = repository;
    }

    public List<series> getAllSeries(){
        return repository.getAllSeries();
    }


    public long createSeries(series newSeries) {
        return repository.createSeries(newSeries);
    }
}
