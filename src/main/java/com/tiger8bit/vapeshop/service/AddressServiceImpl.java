package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Address;
import com.tiger8bit.vapeshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository repository;

    @Override
    public List<Address> findAll() {
        return (List<Address>) repository.findAll();
    }

    @Override
    public Address save(Address value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    @Override
    public Address findByID(long id) {
        return repository.findById(id).get();
    }
}
