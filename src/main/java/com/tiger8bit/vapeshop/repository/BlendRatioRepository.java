package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.BlendRatio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlendRatioRepository extends CrudRepository<BlendRatio, Long> {

}
