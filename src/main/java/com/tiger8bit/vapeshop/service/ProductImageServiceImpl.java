package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ProductImage;
import com.tiger8bit.vapeshop.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository repository;

    @Override
    public List<ProductImage> findAll() {
        return (List<ProductImage>) repository.findAll();
    }

    @Override
    public ProductImage save(ProductImage value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public ProductImage findByID(int id) {
        return repository.findById(id).get();
    }
}
