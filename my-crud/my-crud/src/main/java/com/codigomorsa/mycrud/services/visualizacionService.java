package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.visualizacion;
import com.codigomorsa.mycrud.repositories.visualizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class visualizacionService {
    private final visualizacionRepository repository;

    public visualizacionService(visualizacionRepository repository){
        this.repository = repository;
    }

    public List<visualizacion> getAllVisualizacion(){
        return repository.getAllVisualizacion();
    }


    public long createVisualizacion(visualizacion newVisualizacion) {
        return repository.createVisualizacion(newVisualizacion);
    }
}
