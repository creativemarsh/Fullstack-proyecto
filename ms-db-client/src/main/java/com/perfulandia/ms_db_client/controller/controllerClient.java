package com.perfulandia.ms_db_client.controller;


import com.perfulandia.ms_db_client.model.dto.DTOClient;
import com.perfulandia.ms_db_client.service.serviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador que actúa también como implementación de la Clase ServiceClient.
 */
@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class controllerClient {

    @Autowired
    private serviceClient serviceClient;

    
    @GetMapping("")
    public List<DTOClient> getAllClients() {
        return serviceClient.getAllClients();
    }

    
    @GetMapping("/{id}")
    public DTOClient getClientById(@PathVariable(name = "id" ) Long id) {
        return serviceClient.getClientById(id);
    }

    
    @PostMapping("")
    public DTOClient saveClient(@RequestBody DTOClient dtoClient) {
        return serviceClient.saveClient(dtoClient);
    }

}
