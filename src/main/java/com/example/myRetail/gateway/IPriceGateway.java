package com.example.myRetail.gateway;

import com.example.myRetail.dto.AbstractGatewayRequest;
import com.example.myRetail.dto.AbstractGatewayResponse;
import com.example.myRetail.dto.PriceResponseDTO;

public interface IPriceGateway extends IGateway<AbstractGatewayRequest, AbstractGatewayResponse, PriceResponseDTO> {
     PriceResponseDTO getPrice(String productId);
}
