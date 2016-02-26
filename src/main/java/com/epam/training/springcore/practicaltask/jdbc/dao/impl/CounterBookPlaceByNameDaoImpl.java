package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class CounterBookPlaceByNameDaoImpl extends CounterDaoImpl{

	private final static String TABLE_NAME = "book_place_by_name_counter";
	
	public CounterBookPlaceByNameDaoImpl(JdbcTemplate jdbcTemplate) {
		super(TABLE_NAME, jdbcTemplate);
	}

}
