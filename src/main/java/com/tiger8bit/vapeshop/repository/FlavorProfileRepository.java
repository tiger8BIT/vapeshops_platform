package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.FlavorProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorProfileRepository extends CrudRepository<FlavorProfile, Long> {

}
