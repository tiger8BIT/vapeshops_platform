package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.City;
import com.tiger8bit.vapeshop.model.Country;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City save(City value);
    void deleteByID(int id);
    City findByID(int id);
    List<City> findCitiesByCountry(Country country);
}
