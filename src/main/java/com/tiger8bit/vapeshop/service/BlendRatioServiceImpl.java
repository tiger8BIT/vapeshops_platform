package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.BlendRatio;
import com.tiger8bit.vapeshop.repository.BlendRatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlendRatioServiceImpl implements BlendRatioService {
    @Autowired
    private BlendRatioRepository repository;

    @Override
    public List<BlendRatio> findAll() {
        return (List<BlendRatio>) repository.findAll();
    }

    @Override
    public BlendRatio save(BlendRatio value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public BlendRatio findByID(int id) {
        return repository.findById(id).get();
    }
}
