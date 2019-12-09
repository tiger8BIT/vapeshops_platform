package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Sale;
import java.util.List;

public interface SaleService {
    List<Sale> findAll();
    Sale save(Sale value);
    void deleteByID(int id);
    Sale findByID(int id);
}
