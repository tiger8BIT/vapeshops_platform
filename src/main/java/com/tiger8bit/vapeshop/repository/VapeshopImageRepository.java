package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.VapeshopImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VapeshopImageRepository extends CrudRepository<VapeshopImage, Integer> {

}
