package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Piezas_Compradas;
import com.codigomorsa.mycrud.services.PiezasCompradasService;
import com.codigomorsa.mycrud.services.ServicioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PiezasCompradasController {
    private final PiezasCompradasService PiezasCompradasService;

    public PiezasCompradasController(PiezasCompradasService PiezasCompradasService){
        this.PiezasCompradasService = PiezasCompradasService;
    }

    @GetMapping("/piezasC")
    public List<Piezas_Compradas> getAllPiezasC(){
        return PiezasCompradasService.getAllPiezasC();
    }

    @PostMapping("/piezasC")
    public long createPiezasC(@RequestBody Piezas_Compradas newPiezasC) {
        return PiezasCompradasService.createPiezasC(newPiezasC);
    }
}
