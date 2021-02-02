package com.example.myRetail.mapper;

import com.example.myRetail.dto.PriceResponseDTO;
import com.example.myRetail.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public PriceResponseDTO mapPriceToPriceResponse(Price price){
        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        priceResponseDTO.setCurrency_code(price.getCurrency_code());
        priceResponseDTO.setPrice(price.getValue());
        return priceResponseDTO;
    }
}
