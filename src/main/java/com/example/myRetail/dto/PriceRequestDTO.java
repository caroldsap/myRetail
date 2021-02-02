package com.example.myRetail.dto;

import java.math.BigDecimal;

public class PriceRequestDTO extends AbstractRequestDTO{

    String productId;
    BigDecimal price;
    String currency_code;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
