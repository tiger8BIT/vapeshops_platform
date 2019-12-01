package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ELiquid;
import com.tiger8bit.vapeshop.repository.ELiquidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ELiquidServiceImpl implements ELiquidService {
    @Autowired
    private ELiquidRepository repository;

    @Override
    public List<ELiquid> findAll() {
        return (List<ELiquid>) repository.findAll();
    }

    @Override
    public ELiquid save(ELiquid value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public ELiquid findByID(long id) {
        return repository.findById(id).get();
    }
}
