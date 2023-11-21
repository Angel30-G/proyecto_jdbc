package com.codigomorsa.mycrud.controllers;

import com.codigomorsa.mycrud.model.Cliente;
import com.codigomorsa.mycrud.services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    private final ClienteService ClienteService;

    public ClienteController(ClienteService ClienteService){
        this.ClienteService = ClienteService;
    }

    @GetMapping("/cliente")
    public List<Cliente> getAllClientes(){
        return ClienteService.getAllClientes();
    }

    @PostMapping("/cliente")
    public long createCliente(@RequestBody Cliente newCliente) {
        return ClienteService.createCliente(newCliente);
    }
}
