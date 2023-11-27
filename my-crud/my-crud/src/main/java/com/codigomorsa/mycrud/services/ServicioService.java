package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Vehiculo;
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



    public long createServicioInicial(Servicio newServicio) {
        return repository.createServicioInicial(newServicio);
    }

    public long createCierreServicio(Servicio newServicio){
        return repository.createCierreServicio(newServicio);
    }
    public Servicio getServicioById(long id) {
        return repository.getServicioById(id);
    }

    public Vehiculo getVehiculoByPlaca(String placa){
        return repository.getVehiculoByPlaca(placa);
    }

}
