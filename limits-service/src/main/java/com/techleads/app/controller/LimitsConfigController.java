package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.config.AppPropConfig;
import com.techleads.app.model.LimitConfiguration;
@RefreshScope
@RestController
public class LimitsConfigController {
	@Autowired
	private AppPropConfig appPropConfig;

	@GetMapping(value = { "/limits" })
	public ResponseEntity<LimitConfiguration> limitConfiguration() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(appPropConfig.getMinimum(),
				appPropConfig.getMaximum());

		return new ResponseEntity<>(limitConfiguration, HttpStatus.OK);
	}

}
