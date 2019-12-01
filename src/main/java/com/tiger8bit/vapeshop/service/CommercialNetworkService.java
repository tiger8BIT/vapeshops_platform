package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.CommercialNetwork;
import java.util.List;

public interface CommercialNetworkService {
    List<CommercialNetwork> findAll();
    CommercialNetwork save(CommercialNetwork value);
    void deleteByID(long id);
    CommercialNetwork findByID(long id);
}
