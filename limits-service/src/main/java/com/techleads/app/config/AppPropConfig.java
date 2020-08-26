package com.techleads.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@ConfigurationProperties(prefix = "limits-service")
@Data
public class AppPropConfig {
	
	private Integer maximum;
	private  Integer minimum;
	

}
