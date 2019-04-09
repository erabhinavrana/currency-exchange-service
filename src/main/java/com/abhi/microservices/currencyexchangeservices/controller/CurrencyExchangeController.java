package com.abhi.microservices.currencyexchangeservices.controller;

import com.abhi.microservices.currencyexchangeservices.beans.ExchangeValue;
import com.abhi.microservices.currencyexchangeservices.repository.ExchangeValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Abhinav on 4/4/2019.
 */
@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepo exchangeValueRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = exchangeValueRepo.findByFromAndTo(from, to);//new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        exchangeValue.setPort(environment.getProperty("local.server.port"));
        return exchangeValue;
    }
}
