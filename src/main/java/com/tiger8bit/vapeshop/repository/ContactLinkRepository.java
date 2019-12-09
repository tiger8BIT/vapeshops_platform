package com.tiger8bit.vapeshop.repository;
import com.tiger8bit.vapeshop.model.ContactLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactLinkRepository extends CrudRepository<ContactLink, Integer> {

}
