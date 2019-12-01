package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {

}
