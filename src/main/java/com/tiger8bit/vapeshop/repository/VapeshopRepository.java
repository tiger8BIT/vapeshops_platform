package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Vapeshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VapeshopRepository extends CrudRepository<Vapeshop, Long> {

}
