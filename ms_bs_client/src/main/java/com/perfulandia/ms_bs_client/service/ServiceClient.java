
package com.perfulandia.ms_bs_client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_bs_client.client.ClientBsOpenFeign;
import com.perfulandia.ms_bs_client.model.dto.DTOClient;

@Service
public class ServiceClient {

    @Autowired
    private ClientBsOpenFeign clientBsOpenFeign;

    public List<DTOClient> getAllClients() {
        return clientBsOpenFeign.getAllClients();
    }

    public DTOClient getClientById(Long id) {
        return clientBsOpenFeign.getClientById(id);
    }

    public DTOClient createClient(DTOClient dtoClient) {
        return clientBsOpenFeign.saveClient(dtoClient);
    }

    // ✅ Actualizar cliente
    public DTOClient updateClient(Long id, DTOClient dtoClient) {
        return clientBsOpenFeign.updateClient(id, dtoClient);
    }

    // ✅ Eliminar cliente
    public void deleteClient(Long id) {
        clientBsOpenFeign.deleteClient(id);
    }
}
