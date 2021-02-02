package com.example.myRetail.service;

import com.example.myRetail.dto.PriceRequestDTO;
import com.example.myRetail.dto.PriceResponseDTO;
import com.example.myRetail.dto.ProductDTO;
import com.example.myRetail.mapper.ProductMapper;
import com.example.myRetail.model.Product;
import com.example.myRetail.repository.ProductRepository;
import com.example.myRetail.util.ServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;


public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl service;
    @Mock
    private ProductRepository productRepository;

    @Mock
    ProductMapper productMapper;
    @Mock
    ServiceClient client;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getValidProduct() throws Exception {


        Product product = new Product();
        product.setName("Product 1");
        product.setId(1);
        PriceResponseDTO price = new PriceResponseDTO();
        price.setPrice(new BigDecimal(100));
        price.setCurrency_code("USD");
        Optional<Product> productOptional = Optional.of(product);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        //Mockito.when(service.getPrice(1L)).thenReturn(price);
        ResponseEntity responseEntity = new ResponseEntity(price,HttpStatus.OK);
        Mockito.when(productMapper.mapProductToProductResponse(product)).thenReturn(new ProductDTO());
        Mockito.when(client.get(Mockito.anyString(),Mockito.any())).thenReturn(responseEntity);
        ProductDTO response = service.getProduct("1");
        assertNotNull(response);



    }

    @Test
    public void getInvalidProduct() throws Exception {
        ProductDTO product1 = new ProductDTO();
        product1.setResponseCode("404");
        product1.setMessage("Product Details not found for Product ID:" + 2);

        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = new ResponseEntity(null,HttpStatus.OK);
        Mockito.when(productMapper.mapProductToProductResponse(Mockito.any())).thenReturn(new ProductDTO());
        Mockito.when(client.get(Mockito.anyString(),Mockito.any())).thenReturn(responseEntity);
        ProductDTO response = service.getProduct("1");
        assertNotNull(response);


    }

    @Test
    public void saveProduct() throws Exception {
        ProductDTO product1 = new ProductDTO();
        product1.setName("XYZ");
        product1.setId("1000");
        PriceResponseDTO priceRepsoneDTO = new PriceResponseDTO();
        priceRepsoneDTO.setCurrency_code("USD");
        priceRepsoneDTO.setPrice(new BigDecimal(12121));
        product1.setCurrentPrice(priceRepsoneDTO);

        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product1);
        ProductDTO response = service.saveProduct(product1);
        assertNotNull(response);
    }
}
