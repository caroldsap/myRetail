package com.example.myRetail.service;

import com.example.myRetail.dto.PriceRequestDTO;
import com.example.myRetail.dto.PriceResponseDTO;
import com.example.myRetail.dto.ProductDTO;
import com.example.myRetail.mapper.ProductMapper;
import com.example.myRetail.model.Product;
import com.example.myRetail.repository.ProductRepository;
import com.example.myRetail.util.ServiceClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository repository;

    @Autowired
    PriceService priceService;
    @Autowired
    ServiceClient client;

    @Override
    public ProductDTO getProduct(String id) {
        Optional<Product> product = repository.findById(Long.parseLong(id));

        ProductDTO productDTO;
        if (!product.isPresent()) {
            productDTO = new ProductDTO();
            productDTO.setMessage("Product Details not found for Product ID:" + id);
            productDTO.setResponseCode("404");
            return productDTO;
        }

        productDTO = productMapper.mapProductToProductResponse(product.get());

        //PriceDTO priceDTO = getPrice(product.get().getId());
        ResponseEntity<PriceResponseDTO> responseEntity = client.get("http://localhost:8080/v1/price/" + product.get().getId(),
                PriceResponseDTO.class);
        productDTO.setCurrentPrice(responseEntity.getBody());


        return productDTO;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO newProduct) {
        Product product = new Product();
        if (newProduct.getId() != null) {
            product.setId(Long.parseLong(newProduct.getId()));
        }
        product.setName(newProduct.getName());

        try {
            repository.save(product);
        } catch (Exception e) {
            newProduct.setMessage("Error Occured while Saving/Updating Product Details");
            newProduct.setResponseCode("500");
            return newProduct;
        }
        //Calling the rest api to save the pricing details


        PriceRequestDTO priceRequestDTO = new PriceRequestDTO();
        BeanUtils.copyProperties(newProduct.getCurrentPrice(), priceRequestDTO);
        priceRequestDTO.setProductId(newProduct.getId());
        client.put(
                "http://localhost:8080/v1/price/"+ newProduct.getId(), priceRequestDTO);


        return newProduct;
    }


}
