package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Vapeshop;
import com.tiger8bit.vapeshop.repository.VapeshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VapeshopServiceImpl implements VapeshopService {
    @Autowired
    private VapeshopRepository repository;

    @Override
    public List<Vapeshop> findAll() {
        return (List<Vapeshop>) repository.findAll();
    }

    @Override
    public Vapeshop save(Vapeshop value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Vapeshop findByID(int id) {
        return repository.findById(id).get();
    }
}
