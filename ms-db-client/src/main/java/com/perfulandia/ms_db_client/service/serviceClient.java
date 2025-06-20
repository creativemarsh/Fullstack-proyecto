package com.perfulandia.ms_db_client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.perfulandia.ms_db_client.model.dto.DTOClient;
import com.perfulandia.ms_db_client.model.entities.entityClient;
import com.perfulandia.ms_db_client.model.repositories.repositoryClient;

@Service
public class serviceClient {

    @Autowired
    private repositoryClient repository;


    public List<DTOClient> getAllClients() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }


    public DTOClient getClientById(@PathVariable Long id) {
        entityClient client = repository.findById(id).orElse(null);
        return client != null ? toDto(client) : null;
    }


    public DTOClient saveClient(@RequestBody DTOClient dtoClient) {
        entityClient entity = toEntity(dtoClient);
        return toDto(repository.save(entity));
    }

    // Conversión de Entity a DTO
    private DTOClient toDto(entityClient entity) {
        return new DTOClient(
                entity.getId(),
                entity.getNameClient(),
                entity.getEmailClient(),
                entity.getPhoneClient()
        );
    }

    // Conversión de DTO a Entity
    private entityClient toEntity(DTOClient dto) {
        entityClient entity = new entityClient();
        entity.setId(dto.getId());
        entity.setNameClient(dto.getNameClient());
        entity.setEmailClient(dto.getEmailClient());
        entity.setPhoneClient(dto.getPhoneClient());
        return entity;
    }
}
