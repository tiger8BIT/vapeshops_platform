package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ELiquidFlavorProfile;
import java.util.List;

public interface ELiquidFlavorProfileService {
    List<ELiquidFlavorProfile> findAll();
    ELiquidFlavorProfile save(ELiquidFlavorProfile value);
    void deleteByID(int id);
    ELiquidFlavorProfile findByID(int id);
}
