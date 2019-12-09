package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Delivery;
import java.util.List;

public interface DeliveryService {
    List<Delivery> findAll();
    Delivery save(Delivery value);
    void deleteByID(int id);
    Delivery findByID(int id);
}
