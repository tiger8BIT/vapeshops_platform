package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
