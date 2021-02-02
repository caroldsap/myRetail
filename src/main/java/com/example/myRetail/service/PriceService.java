package com.example.myRetail.service;

import com.example.myRetail.dto.AbstractResponseDTO;
import com.example.myRetail.dto.PriceRequestDTO;
import com.example.myRetail.dto.PriceResponseDTO;

public interface PriceService {
    public PriceResponseDTO getPrice(String productId);

    public AbstractResponseDTO savePrice(PriceRequestDTO newPrice,String productId);
}
