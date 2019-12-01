package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order save(Order value);
    void deleteByID(long id);
    Order findByID(long id);
}
