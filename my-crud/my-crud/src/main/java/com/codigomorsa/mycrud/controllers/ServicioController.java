package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.services.ServicioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServicioController {
    private final ServicioService ServicioService;

    public ServicioController(ServicioService ServiceService){
        this.ServicioService = ServiceService;
    }

    @GetMapping("/taller/{id}/cliente/{id}/servicio")
    public List<Servicio> getAllServicio(){
        return ServicioService.getAllServicio();
    }

    @PostMapping("/taller/{id}/cliente/{id}/servicio")
    public long createServicio(@RequestBody Servicio newServicio) {
        return ServicioService.createServicio(newServicio);
    }
}
