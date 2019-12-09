package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.VapeshopImage;
import com.tiger8bit.vapeshop.repository.VapeshopImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VapeshopImageServiceImpl implements VapeshopImageService {
    @Autowired
    private VapeshopImageRepository repository;

    @Override
    public List<VapeshopImage> findAll() {
        return (List<VapeshopImage>) repository.findAll();
    }

    @Override
    public VapeshopImage save(VapeshopImage value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public VapeshopImage findByID(int id) {
        return repository.findById(id).get();
    }
}
