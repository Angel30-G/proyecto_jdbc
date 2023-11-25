package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.repositories.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository){
        this.repository = repository;
    }

    public List<Servicio> getAllServicio(){
        return repository.getAllServicio();
    }

    public List<Servicio> getAllServicios() {
        return repository.getAllServicios();
    }


    public long createServicio(Servicio newServicio) {
        return repository.createServicio(newServicio);
    }

    public Servicio getServicioById(long id) {
        return repository.getServicioById(id);
    }
}
