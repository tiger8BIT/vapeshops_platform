package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Brand;
import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand save(Brand value);
    void deleteByID(int id);
    Brand findByID(int id);
}
