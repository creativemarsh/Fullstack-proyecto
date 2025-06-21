package com.perfulandia.ms_bs_sales.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.perfulandia.ms_bs_sales.model.dto.DTOClient;

@FeignClient(name = "client", url = "http://localhost:8181/clients")
public interface BsOpenFeignClient {

    @GetMapping("/{id}")
    DTOClient getClientById(@PathVariable("id") Long id);
}
