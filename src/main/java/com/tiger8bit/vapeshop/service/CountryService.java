package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Country;
import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country save(Country value);
    void deleteByID(long id);
    Country findByID(long id);
}
