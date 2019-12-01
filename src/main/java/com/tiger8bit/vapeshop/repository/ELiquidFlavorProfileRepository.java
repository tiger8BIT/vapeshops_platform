package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.ELiquidFlavorProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ELiquidFlavorProfileRepository extends CrudRepository<ELiquidFlavorProfile, Long> {

}
