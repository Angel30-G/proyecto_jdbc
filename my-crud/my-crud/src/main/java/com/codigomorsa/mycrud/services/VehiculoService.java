package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Vehiculo;
import com.codigomorsa.mycrud.repositories.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository){
        this.repository = repository;
    }

    public List<Vehiculo> getAllVehiculo(){
        return repository.getAllVehiculo();
    }


    public long createVehiculo(Vehiculo newVehiculo) {
        return repository.createVehiculo(newVehiculo);
    }
}
