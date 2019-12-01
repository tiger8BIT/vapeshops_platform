package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
