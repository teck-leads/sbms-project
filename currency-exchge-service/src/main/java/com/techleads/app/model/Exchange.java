package com.techleads.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "curexchg_seq", initialValue = 1001, allocationSize = 1)
public class Exchange {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curexchg_seq")
	private Integer id;
	@Column(name = "curr_from")
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	@Transient
	private String port;
	public Exchange(Integer id, String from, String to, BigDecimal conversionMultiple) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}


}
