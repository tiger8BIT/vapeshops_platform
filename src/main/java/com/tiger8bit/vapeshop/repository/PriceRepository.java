package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

}
