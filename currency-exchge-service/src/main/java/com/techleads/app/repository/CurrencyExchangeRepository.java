package com.techleads.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Exchange;
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<Exchange, Integer> {
	Exchange findByFromAndTo(String from, String to);
}
