package com.techleads.app.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techleads.app.model.CurrencyConversion;

//@FeignClient(name = "currency-exchge-service", url ="localhost:8082" )
//@FeignClient(name = "currency-exchge-service")
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchge-service")
public interface CurrenceExchangeServiceProxy {
	//@GetMapping(value = { "/cur-exchnage/from/{from}/to/{to}" })
	@GetMapping(value = { "/currency-exchge-service/cur-exchnage/from/{from}/to/{to}" })
	ResponseEntity<CurrencyConversion> retrievExchangeVal(@PathVariable("from") String from,
			@PathVariable("to") String to);


}
