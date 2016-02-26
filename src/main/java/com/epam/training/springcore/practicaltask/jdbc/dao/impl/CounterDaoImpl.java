package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.springcore.practicaltask.dao.CounterDao;

public class CounterDaoImpl implements CounterDao{

	private final String tableName;
	
	private final JdbcTemplate jdbcTemplate;
	
	public CounterDaoImpl(String tableName, JdbcTemplate jdbcTemplate) {
		this.tableName = tableName;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int getCountByName(String name) {
		try {
			String getCountByName = "SELECT accessCount FROM " + tableName + " WHERE name = ?";
			int count = jdbcTemplate.queryForObject(getCountByName, new Object[] { name },
					Integer.class);
			return count;
		} catch (EmptyResultDataAccessException ex) {
			save(name);
			return 0;
		}
	}

	@Override
	public void updateCountByName(String name) {
		String updateByName = "UPDATE " + tableName + " SET accessCount = ? WHERE name = ?";
		int newCount = getCountByName(name) + 1;
		jdbcTemplate.update(updateByName, newCount, name);
		
	}

	@Override
	public void save(String name) {
		String insertFirstEvent = "INSERT INTO " + tableName + " (name, accessCount) VALUES(?,?)";
		jdbcTemplate.update(insertFirstEvent, name, 0);
		
	}

	@Override
	public void deleteByName(String name) {
		String deleteByName = "DELETE FROM " + tableName + " WHERE name = ?";
		jdbcTemplate.update(deleteByName, name);
	}

}
