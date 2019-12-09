package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

}
