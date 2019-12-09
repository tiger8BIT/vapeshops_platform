package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ProductImage;
import java.util.List;

public interface ProductImageService {
    List<ProductImage> findAll();
    ProductImage save(ProductImage value);
    void deleteByID(int id);
    ProductImage findByID(int id);
}
