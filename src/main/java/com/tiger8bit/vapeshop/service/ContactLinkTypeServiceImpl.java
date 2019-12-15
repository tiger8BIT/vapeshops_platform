package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.ContactLinkType;
import com.tiger8bit.vapeshop.repository.ContactLinkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactLinkTypeServiceImpl implements ContactLinkTypeService{
    @Autowired
    ContactLinkTypeRepository repository;

    @Override
    public List<ContactLinkType> findAll() {
        return (List<ContactLinkType>) repository.findAll();
    }

    @Override
    public ContactLinkType save(ContactLinkType value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public ContactLinkType findByID(int id) {
        return repository.findById(id).get();
    }
}
