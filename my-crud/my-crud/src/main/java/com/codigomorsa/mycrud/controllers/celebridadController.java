package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.celebridad;
import com.codigomorsa.mycrud.services.celebridadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class celebridadController {
    private final celebridadService celebridadService;

    public celebridadController(celebridadService celebridadService){
        this.celebridadService = celebridadService;
    }

    @GetMapping("/celebridad")
    public List<celebridad> getAllCelebridades(){
        return celebridadService.getAllCelebridades();
    }

    @PostMapping("/celebridad")
    public long createCelebridad(@RequestBody celebridad newCelebridad) {
        return celebridadService.createCelebridad(newCelebridad);
    }
}
