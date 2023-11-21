package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.visualizacion;
import com.codigomorsa.mycrud.services.visualizacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class visualizacionController {
    private final visualizacionService visualizacionService;

    public visualizacionController(visualizacionService visualizacionService){
        this.visualizacionService = visualizacionService;
    }

    @GetMapping("/visualizacion")
    public List<visualizacion> getAllVisualizacion(){
        return visualizacionService.getAllVisualizacion();
    }

    @PostMapping("/visualizacion")
    public long createVisualizacion(@RequestBody visualizacion newVisualizacion) {
        return visualizacionService.createVisualizacion(newVisualizacion);
    }
}
