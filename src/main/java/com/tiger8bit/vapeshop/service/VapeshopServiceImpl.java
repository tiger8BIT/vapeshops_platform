package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Vapeshop;
import com.tiger8bit.vapeshop.repository.VapeshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class VapeshopServiceImpl implements VapeshopService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private VapeshopRepository repository;

    @Override
    public List<Vapeshop> findAll() {
        return (List<Vapeshop>) repository.findAll();
    }

    @Override
    public Vapeshop save(Vapeshop value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public Vapeshop findByID(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Integer addVapeshop(String p_address, Integer p_city_fk, Integer p_commercial_network_fk, Boolean p_pickup) {
        return repository.addVapeshop(p_address, p_city_fk, p_commercial_network_fk, p_pickup);
    }
}
