package com.tiger8bit.vapeshop.repository;

import com.tiger8bit.vapeshop.model.Image;
import com.tiger8bit.vapeshop.model.OrderPrice;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>, ImageProcedures {
}
