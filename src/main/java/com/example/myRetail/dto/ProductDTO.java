package com.example.myRetail.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ProductDTO extends AbstractResponseDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    PriceResponseDTO currentPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceResponseDTO getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(PriceResponseDTO currentPrice) {
        this.currentPrice = currentPrice;
    }
}
