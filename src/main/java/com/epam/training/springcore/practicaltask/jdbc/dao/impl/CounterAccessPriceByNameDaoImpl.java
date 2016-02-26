package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class CounterAccessPriceByNameDaoImpl extends CounterDaoImpl {

	private final static String TABLE_NAME = "access_price_by_name_counter";

	public CounterAccessPriceByNameDaoImpl(JdbcTemplate jdbcTemplate) {
		super(TABLE_NAME, jdbcTemplate);
	
	}

}
