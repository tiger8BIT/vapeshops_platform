package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.CommercialNetwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialNetworkRepository extends CrudRepository<CommercialNetwork, Integer> {

}
