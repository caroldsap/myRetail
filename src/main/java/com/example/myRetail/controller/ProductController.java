package com.example.myRetail.controller;
import com.example.myRetail.dto.ProductDTO;
import com.example.myRetail.model.Product;
import com.example.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable(value = "id") String id){
        return productService.getProduct(id);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveOrUpdate(
            @RequestBody ProductDTO newProduct,
            @PathVariable(value = "id") String id){

        newProduct.setId(id);
        return productService.saveProduct(newProduct);
    }
}
