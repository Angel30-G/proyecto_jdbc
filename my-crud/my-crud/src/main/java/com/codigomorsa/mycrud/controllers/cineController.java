package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.cine;
import com.codigomorsa.mycrud.services.cineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class cineController {
    private final cineService cineService;

    public cineController(cineService cineService){
        this.cineService = cineService;
    }

    @GetMapping("/cine")
    public List<cine> getAllCine(){
        return cineService.getAllCine();
    }

    @PostMapping("/cine")
    public long createCine(@RequestBody cine newCine) {
        return cineService.createCine(newCine);
    }
}
