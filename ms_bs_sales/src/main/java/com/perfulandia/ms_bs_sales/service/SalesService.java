package com.perfulandia.ms_bs_sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_bs_sales.client.BsOpenFeignSales;
import com.perfulandia.ms_bs_sales.client.BsOpenFeignClient;
import com.perfulandia.ms_bs_sales.client.BsOpenFeignProduct;
import com.perfulandia.ms_bs_sales.model.dto.ProductDTO;
import com.perfulandia.ms_bs_sales.model.dto.SalesDTO;
import com.perfulandia.ms_bs_sales.model.dto.SalesDetailDTO;

@Service
public class SalesService {
    @Autowired
    private BsOpenFeignSales BsOpenFeignSales;
    @Autowired
    private BsOpenFeignClient BsOpenFeignClient;
    @Autowired
    private BsOpenFeignProduct BsOpenFeignProduct;


    public List<SalesDTO> getAllSales() {
        List<SalesDTO> sales = BsOpenFeignSales.getAllSales();
        for (SalesDTO sale : sales) {
            sale.setClient(BsOpenFeignClient.getClientById(sale.getClient().getId()));
            
        }
        return sales;
        
    }

    public SalesDTO getSalesById(Long id) {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO = BsOpenFeignSales.getSaleById(id);
        salesDTO.setClient(BsOpenFeignClient.getClientById(salesDTO.getClient().getId()));
        return salesDTO;
    }



    public SalesDTO createSale(SalesDTO salesDTO) {
        return BsOpenFeignSales.createSale(salesDTO);
    }

    public SalesDTO updateSale(SalesDTO salesDTO) {
        return BsOpenFeignSales.updateSale(salesDTO);
    }

    public String deleteSale(Long id) {
        BsOpenFeignSales.deleteSale(id);
        return "Sale deleted";
    }





    public List<SalesDetailDTO> getSalesByClientId(Long id) {
        List<SalesDetailDTO> sales = BsOpenFeignSales.getSalesByClientId(id);
        for (SalesDetailDTO sale : sales) {
            sale.setProduct(BsOpenFeignProduct.getProductById(sale.getProduct().getId()));
        }
        return sales;
    }


    public SalesDetailDTO createSalesDetail(SalesDetailDTO salesDetailDTO) {
        BsOpenFeignSales.saveSalesDetail(salesDetailDTO);
        return salesDetailDTO;
    }

    public SalesDetailDTO updateSalesDetail(SalesDetailDTO salesDetailDTO) {
        return BsOpenFeignSales.updateSalesDetail(salesDetailDTO);
    }

    public String deleteSalesDetail(Long id) {
        BsOpenFeignSales.deleteSalesDetail(id);
        return "Detail deleted";
    }

    public String saveProduct(ProductDTO productDTO) {
        BsOpenFeignProduct.saveProduct(productDTO);
        return "Product saved";
    }
}
