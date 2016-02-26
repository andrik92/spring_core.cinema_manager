package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class CounterAccessByNameDaoImpl extends CounterDaoImpl{

	private final static String TABLE_NAME = "access_by_name_counter";
	
	public CounterAccessByNameDaoImpl(JdbcTemplate jdbcTemplate) {
		super(TABLE_NAME, jdbcTemplate);
	}

}
