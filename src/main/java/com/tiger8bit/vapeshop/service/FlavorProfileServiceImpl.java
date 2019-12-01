package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.FlavorProfile;
import com.tiger8bit.vapeshop.repository.FlavorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlavorProfileServiceImpl implements FlavorProfileService {
    @Autowired
    private FlavorProfileRepository repository;

    @Override
    public List<FlavorProfile> findAll() {
        return (List<FlavorProfile>) repository.findAll();
    }

    @Override
    public FlavorProfile save(FlavorProfile value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public FlavorProfile findByID(long id) {
        return repository.findById(id).get();
    }
}
