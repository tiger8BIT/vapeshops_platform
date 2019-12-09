package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ContactLink;
import com.tiger8bit.vapeshop.repository.ContactLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactLinkServiceImpl implements ContactLinkService {
    @Autowired
    private ContactLinkRepository repository;

    @Override
    public List<ContactLink> findAll() {
        return (List<ContactLink>) repository.findAll();
    }

    @Override
    public ContactLink save(ContactLink value) {
        return repository.save(value);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }

    @Override
    public ContactLink findByID(int id) {
        return repository.findById(id).get();
    }
}
