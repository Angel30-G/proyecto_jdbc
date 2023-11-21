package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Vehiculo;
import com.codigomorsa.mycrud.services.VehiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/vehiculo")
    public List<Vehiculo> getAllVehiculos(){
        return vehiculoService.getAllVehiculos();
    }

    @PostMapping("/vehiculo")
    public long createVehiculo(@RequestBody Vehiculo newVehiculo) {
        return vehiculoService.createVehiculo(newVehiculo);
    }
}
