package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Delivery;
import com.tiger8bit.vapeshop.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository repository;

    @Override
    public List<Delivery> findAll() {
        return (List<Delivery>) repository.findAll();
    }

    @Override
    public Delivery save(Delivery value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Delivery findByID(int id) {
        return repository.findById(id).get();
    }
}
