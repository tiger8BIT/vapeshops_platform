package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.Address;
import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address save(Address value);
    void deleteByID(long id);
    Address findByID(long id);
}
