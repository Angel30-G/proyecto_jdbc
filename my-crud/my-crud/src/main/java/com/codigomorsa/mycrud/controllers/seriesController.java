package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.series;
import com.codigomorsa.mycrud.services.seriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class seriesController {
    private final seriesService seriesService;

    public seriesController(seriesService seriesService){
        this.seriesService = seriesService;
    }

    @GetMapping("/series")
    public List<series> getAllSeries(){
        return seriesService.getAllSeries();
    }

    @PostMapping("/series")
    public long createSeries(@RequestBody series newSeries) {
        return seriesService.createSeries(newSeries);
    }
}
