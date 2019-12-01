package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Order;
import com.tiger8bit.vapeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }

    @Override
    public Order save(Order value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public Order findByID(long id) {
        return repository.findById(id).get();
    }
}
