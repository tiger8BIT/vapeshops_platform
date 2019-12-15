package com.tiger8bit.vapeshop.repository;

import com.tiger8bit.vapeshop.model.Currency;
import com.tiger8bit.vapeshop.model.OrderPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}
