package com.example.myRetail.mapper;

import com.example.myRetail.dto.ProductDTO;
import com.example.myRetail.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO mapProductToProductResponse(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(Long.toString(product.getId()));
        productDTO.setName(product.getName());
        return productDTO;
    }
}
