package com.tiger8bit.vapeshop.repository;

public interface VapeshopProcedures {
    Integer addVapeshop(String p_address, Integer p_city_fk, Integer p_commercial_network_fk, Boolean p_pickup);
}
