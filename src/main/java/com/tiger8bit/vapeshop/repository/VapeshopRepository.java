package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.Vapeshop;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VapeshopRepository extends CrudRepository<Vapeshop, Integer> {
    @Procedure(name = "add_vapeshop")
    Integer addVapeshop(@Param("p_address") String p_address,
                        @Param("p_city_fk") Integer p_city_fk,
                        @Param("p_commercial_network_fk") Integer p_commercial_network_fk,
                        @Param("p_pickup") Boolean p_pickup);
}
