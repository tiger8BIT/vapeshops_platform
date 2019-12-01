package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.PhoneNumber;
import com.tiger8bit.vapeshop.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository repository;

    @Override
    public List<PhoneNumber> findAll() {
        return (List<PhoneNumber>) repository.findAll();
    }

    @Override
    public PhoneNumber save(PhoneNumber value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public PhoneNumber findByID(long id) {
        return repository.findById(id).get();
    }
}
