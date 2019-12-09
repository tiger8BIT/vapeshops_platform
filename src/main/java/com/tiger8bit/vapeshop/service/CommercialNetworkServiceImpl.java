package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.CommercialNetwork;
import com.tiger8bit.vapeshop.repository.CommercialNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercialNetworkServiceImpl implements CommercialNetworkService {
    @Autowired
    private CommercialNetworkRepository repository;

    @Override
    public List<CommercialNetwork> findAll() {
        return (List<CommercialNetwork>) repository.findAll();
    }

    @Override
    public CommercialNetwork save(CommercialNetwork value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public CommercialNetwork findByID(int id) {
        return repository.findById(id).get();
    }
}
