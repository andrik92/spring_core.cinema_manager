package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.jdbc.mapper.JodaTimeSavvyBeanPropertyRowMapper;

public class EventDaoImpl extends AbstractDaoImpl<Event> implements EventDao {

	private final static String TABLE_NAME = "event";
	
	public EventDaoImpl(JdbcTemplate jdbcTemplate) {
		super(new JodaTimeSavvyBeanPropertyRowMapper<Event>(Event.class), TABLE_NAME, jdbcTemplate);
	}
	

	@Override
	public Event save(Event event) {
		String insert = "INSERT INTO " + TABLE_NAME + "(name, basePrive, raiting) values (?, ?, ?)";
		jdbcTemplate.update(insert, event.getName(), event.getBasePrice(),event.getRating());
		return null;
	}

	@Override
	public Event getByName(String name) {
		Object[] params = {name};
		String findByFirstName = "SELECT * FROM " + TABLE_NAME + " WHERE name = ?";
		return jdbcTemplate.query(findByFirstName, params, rowMapper).get(0);
	}

}
