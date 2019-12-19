package com.tiger8bit.vapeshop.service;
import com.tiger8bit.vapeshop.model.CommercialNetwork;
import com.tiger8bit.vapeshop.model.Vapeshop;
import java.util.List;

public interface VapeshopService {
    List<Vapeshop> findAll();
    List<Vapeshop> findAllByCommercialNetwork(CommercialNetwork commercialNetwork);
    Vapeshop save(Vapeshop value);
    void deleteByID(int id);
    Vapeshop findByID(int id);
    Integer addVapeshop(String p_address, Integer p_city_fk, Integer p_commercial_network_fk, Boolean p_pickup);
}
