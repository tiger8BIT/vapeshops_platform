package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {

}
