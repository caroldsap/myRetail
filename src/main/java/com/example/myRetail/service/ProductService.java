package com.example.myRetail.service;

import com.example.myRetail.dto.ProductDTO;


public interface ProductService {

    public ProductDTO getProduct(String productId);
    public ProductDTO saveProduct(ProductDTO newProduct);
}
