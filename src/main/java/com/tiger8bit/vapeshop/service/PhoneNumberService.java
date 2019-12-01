package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.PhoneNumber;
import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> findAll();
    PhoneNumber save(PhoneNumber value);
    void deleteByID(long id);
    PhoneNumber findByID(long id);
}
