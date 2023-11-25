package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.services.ServicioService;
import com.codigomorsa.mycrud.services.TallerService;
import com.codigomorsa.mycrud.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicioController {
    private final ServicioService ServicioService;

    public Servicio servicio;

    public ServicioController(ServicioService ServiceService){
        this.ServicioService = ServiceService;
    }

    @GetMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable long idServicio) {

        // Aquí puedes agregar lógica para validar que el servicio pertenezca al cliente y taller indicados

        Servicio servicio = ServicioService.getServicioById(idServicio);
        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/taller/{id}/cliente/{id}/servicio")
    public List<Servicio> getAllServicio(){
        return ServicioService.getAllServicio();
    }

    @GetMapping("/servicio")
    public List<Servicio> getAllServicios() {
        return ServicioService.getAllServicios();
    }

    @PostMapping("/taller/{id}/cliente/{id}/servicio")
    public long createServicio(@RequestBody Servicio newServicio) {
        return ServicioService.createServicio(newServicio);
    }
}
