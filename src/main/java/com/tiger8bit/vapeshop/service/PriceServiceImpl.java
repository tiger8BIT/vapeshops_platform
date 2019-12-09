package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Price;
import com.tiger8bit.vapeshop.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository repository;

    @Override
    public List<Price> findAll() {
        return (List<Price>) repository.findAll();
    }

    @Override
    public Price save(Price value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Price findByID(int id) {
        return repository.findById(id).get();
    }
}
