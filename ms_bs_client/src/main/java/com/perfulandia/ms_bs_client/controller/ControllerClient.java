package com.perfulandia.ms_bs_client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.ms_bs_client.model.dto.DTOClient;
import com.perfulandia.ms_bs_client.service.ServiceClient;

@RequestMapping("/clients")
@RestController
@CrossOrigin("*")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @GetMapping("")
    public List<DTOClient> getAllClients() {
        return serviceClient.getAllClients();
    }

    @GetMapping("/{id}")
    public DTOClient getClientById(@PathVariable Long id) {
        return serviceClient.getClientById(id);
    }

    @PostMapping("")
    public DTOClient createClient(@RequestBody DTOClient dtoClient) {
        return serviceClient.createClient(dtoClient);
    }    
}
