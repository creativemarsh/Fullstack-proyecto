package com.perfulandia.ms_bs_client.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.perfulandia.ms_bs_client.model.dto.DTOClient;

@FeignClient(name = "Client", url = "http://localhost:8180/clients")
public interface ClientBsOpenFeign {

    @GetMapping("")
    List<DTOClient> getAllClients();

    @GetMapping("/{id}")
    DTOClient getClientById(@PathVariable("id") Long id);

    @PostMapping("")
    DTOClient saveClient(@RequestBody DTOClient dtoClient);

    // ✅ PUT para actualizar cliente
    @PutMapping("/{id}")
    DTOClient updateClient(@PathVariable("id") Long id, @RequestBody DTOClient dtoClient);

    // ✅ DELETE para eliminar cliente
    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable("id") Long id);
}
