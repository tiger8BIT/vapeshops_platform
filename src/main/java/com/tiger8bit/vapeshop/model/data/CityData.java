package com.tiger8bit.vapeshop.model.data;

import com.tiger8bit.vapeshop.model.City;
import lombok.Data;

@Data
public class CityData {
    private Integer id;
    private String name;
    public CityData(City city) {
        id = city.getId();
        name = city.getName();
    }
}
