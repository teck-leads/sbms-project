package com.techleads.app.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.model.CurrencyConversion;
import com.techleads.app.proxy.CurrenceExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrenceExchangeServiceProxy currenceExchangeServiceProxy;

	@GetMapping(value = { "/cur-converter/from/{from}/to/{to}/qty/{qty}" })
	public ResponseEntity<CurrencyConversion> convertCurrency(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("qty") BigDecimal qty) {
		String portNum = environment.getProperty("local.server.port");

		ResponseEntity<CurrencyConversion> response = currenceExchangeServiceProxy.retrievExchangeVal(from, to);

		CurrencyConversion currency = response.getBody();

		CurrencyConversion currencyConversion = new CurrencyConversion(currency.getId(), from, to,
				currency.getConversionMultiple(), qty, qty.multiply(currency.getConversionMultiple()), currency.getPort());
		return new ResponseEntity<>(currencyConversion, HttpStatus.OK);

	}

	/* without Feign client
	@GetMapping(value = { "/cur-converter/from/{from}/to/{to}/qty/{qty}" })
	public ResponseEntity<CurrencyConversion> convertCurrencybkp(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("qty") BigDecimal qty) {
		String portNum = environment.getProperty("local.server.port");

		String url = "http://localhost:8082//cur-exchnage/from/{from}/to/{to}";
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(url, CurrencyConversion.class,
				uriVariables);
		CurrencyConversion currency = response.getBody();

		CurrencyConversion currencyConversion = new CurrencyConversion(currency.getId(), from, to,
				currency.getConversionMultiple(), qty, qty.multiply(currency.getConversionMultiple()), portNum);
		return new ResponseEntity<>(currencyConversion, HttpStatus.OK);

	}
	*/

}
