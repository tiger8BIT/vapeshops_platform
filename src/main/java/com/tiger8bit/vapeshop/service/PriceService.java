package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Price;
import java.util.List;

public interface PriceService {
    List<Price> findAll();
    Price save(Price value);
    void deleteByID(long id);
    Price findByID(long id);
}
