package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> findAll();
    Currency save(Currency value);
    void deleteByID(int id);
    Currency findByID(int id);
}
