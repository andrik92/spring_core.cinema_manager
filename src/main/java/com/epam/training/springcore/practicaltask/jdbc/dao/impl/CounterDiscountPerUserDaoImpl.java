package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class CounterDiscountPerUserDaoImpl extends CounterDaoImpl{

	private final static String TABLE_NAME = "discount_per_user_counter";
	
	public CounterDiscountPerUserDaoImpl(JdbcTemplate jdbcTemplate) {
		super(TABLE_NAME, jdbcTemplate);
		
	}

}
