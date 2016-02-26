package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class CounterDiscountDaoImpl extends CounterDaoImpl{

	private final static String TABLE_NAME = "discount_counter";
	
	public CounterDiscountDaoImpl(JdbcTemplate jdbcTemplate) {
		super(TABLE_NAME, jdbcTemplate);
	}

}
