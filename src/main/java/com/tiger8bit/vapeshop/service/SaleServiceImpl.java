package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Sale;
import com.tiger8bit.vapeshop.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository repository;

    @Override
    public List<Sale> findAll() {
        return (List<Sale>) repository.findAll();
    }

    @Override
    public Sale save(Sale value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Sale findByID(int id) {
        return repository.findById(id).get();
    }
}
