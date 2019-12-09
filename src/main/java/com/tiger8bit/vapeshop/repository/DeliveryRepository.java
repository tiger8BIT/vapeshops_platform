package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {

}
