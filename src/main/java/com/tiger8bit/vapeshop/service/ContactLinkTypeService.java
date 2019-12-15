package com.tiger8bit.vapeshop.service;

import com.tiger8bit.vapeshop.model.ContactLinkType;

import java.util.List;

public interface ContactLinkTypeService {
    List<ContactLinkType> findAll();
    ContactLinkType save(ContactLinkType value);
    void deleteByID(int id);
    ContactLinkType findByID(int id);
}
