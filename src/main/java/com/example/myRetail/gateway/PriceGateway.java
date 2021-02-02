package com.example.myRetail.gateway;

import com.example.myRetail.dto.AbstractGatewayRequest;
import com.example.myRetail.dto.AbstractGatewayResponse;
import com.example.myRetail.dto.AbstractResponseDTO;

import java.util.List;

public class PriceGateway  implements IGateway{
    @Override
    public Class getGatewayRequestClass() {
        return AbstractGatewayRequest.class;
    }

    @Override
    public Class getGatewayResponseClass() {
        return AbstractGatewayResponse.class;
    }

    @Override
    public String getGatewayServicePrefix() {
        return "price.get-price";
    }

    @Override
    public String getGatewayServiceCircuitBreakerGroup() {
        return "price.get-price-service-group";
    }

    @Override
    public List readAll(AbstractGatewayRequest request) {
        return null;
    }

    @Override
    public AbstractResponseDTO read(AbstractGatewayRequest request) {
        return null;
    }

    @Override
    public AbstractGatewayResponse update(AbstractGatewayRequest request) {
        return null;
    }
}
