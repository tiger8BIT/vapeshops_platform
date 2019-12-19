package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.CommercialNetwork;
import java.util.List;

public interface CommercialNetworkService {
    List<CommercialNetwork> findAll();
    CommercialNetwork save(CommercialNetwork value);
    CommercialNetwork update(CommercialNetwork value);
    void deleteByID(int id);
    CommercialNetwork findByID(int id);
    CommercialNetwork findByUsername(String username);
}
