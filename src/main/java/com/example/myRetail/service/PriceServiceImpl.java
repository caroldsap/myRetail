package com.example.myRetail.service;

import com.example.myRetail.dto.AbstractResponseDTO;
import com.example.myRetail.dto.PriceRequestDTO;
import com.example.myRetail.dto.PriceResponseDTO;
import com.example.myRetail.mapper.PriceMapper;
import com.example.myRetail.model.Price;
import com.example.myRetail.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements  PriceService {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    PriceMapper priceMapper;
    @Override
    public PriceResponseDTO getPrice(String productId) {
        List<Price> priceList = priceRepository.findByProductId(Long.parseLong(productId));
        PriceResponseDTO priceResponseDTO;
        if(priceList!=null && priceList.get(0)!=null){
             priceResponseDTO = priceMapper.mapPriceToPriceResponse(priceList.get(0));

            return priceResponseDTO;
        }
        priceResponseDTO = new PriceResponseDTO();
        priceResponseDTO.setMessage("Cannot get Price Details");
        priceResponseDTO.setResponseCode("500");
        return priceResponseDTO;
    }

    @Override
    public AbstractResponseDTO savePrice(PriceRequestDTO newPrice,String productId) {
        List<Price> priceList = priceRepository.findByProductId(Long.parseLong(newPrice.getProductId()));
        Price price = null;
        if(priceList!=null && priceList.get(0)!=null){
            price= priceList.get(0);
        } else{
            price = new Price();
        }

        price.setProductId(Long.parseLong(newPrice.getProductId()));
        price.setCurrency_code(newPrice.getCurrency_code());
        price.setValue(newPrice.getPrice());
        AbstractResponseDTO responseDTO = new AbstractResponseDTO();
        try{
            priceRepository.save(price);
        } catch (Exception e){
            responseDTO.setMessage("Error Occured while Saving/Updating Price Details");
            responseDTO.setResponseCode("500");
        }
        return responseDTO;

    }
}
