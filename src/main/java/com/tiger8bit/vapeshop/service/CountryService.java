package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Country;
import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country save(Country value);
    void deleteByID(int id);
    Country findByID(int id);
}
