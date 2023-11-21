package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Taller;
import com.codigomorsa.mycrud.services.TallerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TallerController {
    private final TallerService TallerService;

    public TallerController(TallerService TallerService){
        this.TallerService = TallerService;
    }

    @GetMapping("/taller")
    public List<Taller> getAllTaller(){
        return TallerService.getAllTaller();
    }

    @PostMapping("/taller")
    public long createTaller(@RequestBody Taller newTaller) {
        return TallerService.createTaller(newTaller);
    }
}
