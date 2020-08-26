package com.techleads.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Exchange;
import com.techleads.app.service.CurrencyExchangeService;

@RestController
public class CurrenceExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping(value = { "/cur-exchnage/from/{from}/to/{to}" })
	public ResponseEntity<Exchange> retrievExchangeVal(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		String portNum = environment.getProperty("local.server.port");
		Exchange exchange = currencyExchangeService.findByFromTo(from, to);
		
		
		if(!StringUtils.isEmpty(exchange)) {
			exchange.setPort(portNum);
		}
		return new ResponseEntity<>(exchange, HttpStatus.OK);

	}

}
