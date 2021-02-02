package com.example.myRetail.repository;

import com.example.myRetail.model.Price;
import com.example.myRetail.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    List<Price> findByProductId(long productId);
}
