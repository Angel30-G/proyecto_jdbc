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
    private final VehiculoService VehiculoService;

    public VehiculoController(VehiculoService VehiculoService){
        this.VehiculoService = VehiculoService;
    }

    @GetMapping("/vehiculo")
    public List<Vehiculo> getAllVehiculo(){
        return VehiculoService.getAllVehiculo();
    }

    @PostMapping("/vehiculo")
    public long createVehiculo(@RequestBody Vehiculo newVehiculo) {
        return VehiculoService.createVehiculo(newVehiculo);
    }
}
