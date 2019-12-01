package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.City;
import com.tiger8bit.vapeshop.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    List<City> getCitiesByCountry(Country country);
}
