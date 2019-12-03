package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Country;
import com.tiger8bit.vapeshop.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return (List<Country>) repository.findAll();
    }

    @Override
    public Country save(Country value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Country findByID(int id) {
        return repository.findById(id).get();
    }
}
