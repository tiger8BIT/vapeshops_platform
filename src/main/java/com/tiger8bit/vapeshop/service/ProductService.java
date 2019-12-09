package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product value);
    void deleteByID(int id);
    Product findByID(int id);
}
