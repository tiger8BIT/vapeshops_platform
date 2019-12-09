package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

}
