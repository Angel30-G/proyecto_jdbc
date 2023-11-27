package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Servicio;
import com.codigomorsa.mycrud.model.Vehiculo;
import com.codigomorsa.mycrud.services.ServicioService;
import com.codigomorsa.mycrud.services.TallerService;
import com.codigomorsa.mycrud.services.ClienteService;
import com.codigomorsa.mycrud.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ServicioController {
    private final ServicioService ServicioService;

    //private VehiculoService vehiculoService;
    public Servicio servicio;

    public Vehiculo vehiculo;

    public ServicioController(ServicioService ServiceService){
        this.ServicioService = ServiceService;
    }

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private VehiculoService vehiculoService;  // Asegúrate de tener la anotación @Autowired para la inyección de dependencias

   /* @GetMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable long idServicio) {

        // Aquí puedes agregar lógica para validar que el servicio pertenezca al cliente y taller indicados

        Servicio servicio = ServicioService.getServicioById(idServicio);
        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } */

    @GetMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable long idServicio) {
        Servicio servicio = servicioService.getServicioById(idServicio);

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
        return ServicioService.createServicioInicial(newServicio);
    }

<<<<<<< HEAD
    @PostMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{id}")
    public ResponseEntity<Long> createServicio(@RequestBody Servicio newServicio, @PathVariable long id) {
        vehiculoService.createVehiculoPlaca(vehiculo);
        // Verificar si el vehículo y la placa existen
        if (servicioService.getVehiculoByPlaca(vehiculo.getNumero_placa()) != null) {
            // La placa existe, puedes continuar con la creación del servicio
            long servicioId = ServicioService.createServicioInicial(newServicio);
            return new ResponseEntity<>(servicioId, HttpStatus.CREATED);
        } else {
            // Placa no encontrada o vehículo nulo, devuelve un error
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PatchMapping("/taller/{id}/cliente/{id}/servicio/{id}")
    public long createCierreServicio(@RequestBody Servicio newServicio){
        return ServicioService.createCierreServicio(newServicio);
    }
=======
    @PatchMapping("/taller/{idTaller}/cliente/{idCliente}/servicio/{idServicio}")
public long createCierreServicio(@RequestBody Servicio newServicio, @PathVariable long idServicio){
    return ServicioService.createCierreServicio(newServicio, idServicio);
}

>>>>>>> b917fd628dd8fcac8a5ceb5f2cbaeeb21be754fc

   


}

