package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Pieza;
import com.codigomorsa.mycrud.services.PiezaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PiezaController {
    private final PiezaService PiezaService;

    public PiezaController(PiezaService PiezaService){
        this.PiezaService = PiezaService;
    }

    @GetMapping("/pieza")
    public List<Pieza> getAllPiezas(){
        return PiezaService.getAllPiezas();
    }

    @PostMapping("/pieza")
    public long createPieza(@RequestBody Pieza newPieza) {
        return PiezaService.createPieza(newPieza);
    }
}
