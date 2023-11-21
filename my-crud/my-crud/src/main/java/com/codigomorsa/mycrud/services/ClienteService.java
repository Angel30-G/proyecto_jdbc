package com.codigomorsa.mycrud.services;

import com.codigomorsa.mycrud.model.Cliente;
import com.codigomorsa.mycrud.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> getAllClientes(){
        return repository.getAllClientes();
    }


    public long createCliente(Cliente newCliente) {
        return repository.createCliente(newCliente);
    }
}
