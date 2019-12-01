package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.OrderPrice;
import com.tiger8bit.vapeshop.repository.OrderPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPriceServiceImpl implements OrderPriceService {
    @Autowired
    private OrderPriceRepository repository;

    @Override
    public List<OrderPrice> findAll() {
        return (List<OrderPrice>) repository.findAll();
    }

    @Override
    public OrderPrice save(OrderPrice value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public OrderPrice findByID(long id) {
        return repository.findById(id).get();
    }
}
