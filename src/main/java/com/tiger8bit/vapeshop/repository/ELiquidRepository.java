package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.ELiquid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ELiquidRepository extends CrudRepository<ELiquid, Integer> {

}
