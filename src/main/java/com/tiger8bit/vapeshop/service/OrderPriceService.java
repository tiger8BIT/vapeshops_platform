package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.OrderPrice;
import java.util.List;

public interface OrderPriceService {
    List<OrderPrice> findAll();
    OrderPrice save(OrderPrice value);
    void deleteByID(long id);
    OrderPrice findByID(long id);
}
