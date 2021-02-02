package com.example.myRetail.model;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="Price")
public class Price {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "product_id")
    private long productId;
    @Column(name = "value")
    BigDecimal value;
    @Column(name = "currency_code")
    String currency_code ;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
