package com.example.myRetail.gateway;

import com.example.myRetail.dto.AbstractGatewayRequest;
import com.example.myRetail.dto.AbstractGatewayResponse;
import com.example.myRetail.dto.AbstractResponseDTO;

import java.util.List;

public interface IGateway<GR extends AbstractGatewayRequest,
        GRS extends AbstractGatewayResponse,
        GD extends AbstractResponseDTO> {

    Class<GR> getGatewayRequestClass();
    Class<GRS> getGatewayResponseClass();
    String getGatewayServicePrefix();
    String getGatewayServiceCircuitBreakerGroup();

    List<GD> readAll(GR request);
    GD read(GR request);
    GRS update (GR request);

}
