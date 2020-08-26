package com.techleads.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Exchange;
import com.techleads.app.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	
	public Exchange findByFromTo(String from, String to) {
		Exchange findByFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
		return findByFromAndTo;
	}

}
