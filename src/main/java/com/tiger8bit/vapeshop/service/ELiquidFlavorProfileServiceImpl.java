package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ELiquidFlavorProfile;
import com.tiger8bit.vapeshop.repository.ELiquidFlavorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ELiquidFlavorProfileServiceImpl implements ELiquidFlavorProfileService {
    @Autowired
    private ELiquidFlavorProfileRepository repository;

    @Override
    public List<ELiquidFlavorProfile> findAll() {
        return (List<ELiquidFlavorProfile>) repository.findAll();
    }

    @Override
    public ELiquidFlavorProfile save(ELiquidFlavorProfile value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public ELiquidFlavorProfile findByID(long id) {
        return repository.findById(id).get();
    }
}
