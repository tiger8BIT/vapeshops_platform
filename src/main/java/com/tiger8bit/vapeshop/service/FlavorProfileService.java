package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.FlavorProfile;
import java.util.List;

public interface FlavorProfileService {
    List<FlavorProfile> findAll();
    FlavorProfile save(FlavorProfile value);
    void deleteByID(int id);
    FlavorProfile findByID(int id);
}
