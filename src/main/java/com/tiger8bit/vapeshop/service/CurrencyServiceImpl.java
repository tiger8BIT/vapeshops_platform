package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.Currency;
import com.tiger8bit.vapeshop.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository repository;

    @Override
    public List<Currency> findAll() {
        return (List<Currency>) repository.findAll();
    }

    @Override
    public Currency save(Currency value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Currency findByID(int id) {
        return repository.findById(id).get();
    }
}
