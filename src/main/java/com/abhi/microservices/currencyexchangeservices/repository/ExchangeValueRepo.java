package com.abhi.microservices.currencyexchangeservices.repository;

import com.abhi.microservices.currencyexchangeservices.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abhinav on 4/8/2019.
 */
@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long> {

   ExchangeValue findByFromAndTo(String from, String to);
}
