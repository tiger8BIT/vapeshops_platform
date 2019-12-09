package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Brand;
import com.tiger8bit.vapeshop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repository;

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) repository.findAll();
    }

    @Override
    public Brand save(Brand value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Brand findByID(int id) {
        return repository.findById(id).get();
    }
}
