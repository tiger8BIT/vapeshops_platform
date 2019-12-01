package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.City;
import com.tiger8bit.vapeshop.model.Country;
import com.tiger8bit.vapeshop.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    @Override
    public City save(City value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public City findByID(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<City> findCitiesByCountry(Country country) {
        return repository.getCitiesByCountry(country);
    }
}
