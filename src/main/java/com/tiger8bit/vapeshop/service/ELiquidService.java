package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ELiquid;
import java.util.List;

public interface ELiquidService {
    List<ELiquid> findAll();
    ELiquid save(ELiquid value);
    void deleteByID(long id);
    ELiquid findByID(long id);
}
