package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Vapeshop;
import java.util.List;

public interface VapeshopService {
    List<Vapeshop> findAll();
    Vapeshop save(Vapeshop value);
    void deleteByID(int id);
    Vapeshop findByID(int id);
}
