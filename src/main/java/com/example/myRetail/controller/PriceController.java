package com.example.myRetail.controller;

import com.example.myRetail.dto.AbstractResponseDTO;
import com.example.myRetail.dto.PriceRequestDTO;
import com.example.myRetail.dto.PriceResponseDTO;
import com.example.myRetail.service.PriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class PriceController {
    @Autowired
    PriceService priceService;

    @GetMapping(value = "/price/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    private PriceResponseDTO getPrice(@PathVariable(value = "id") String id){
        return priceService.getPrice(id);
    }

    @PutMapping("/price/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AbstractResponseDTO saveOrUpdate(
            @RequestBody PriceRequestDTO newPrice,
            @PathVariable(value = "id") String productId){
        return priceService.savePrice(newPrice,productId);
    }
}
