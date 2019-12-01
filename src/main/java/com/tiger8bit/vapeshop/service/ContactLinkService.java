package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.ContactLink;
import java.util.List;

public interface ContactLinkService {
    List<ContactLink> findAll();
    ContactLink save(ContactLink value);
    void deleteByID(long id);
    ContactLink findByID(long id);
}
