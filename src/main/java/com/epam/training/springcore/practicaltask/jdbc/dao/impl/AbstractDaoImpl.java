package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.training.springcore.practicaltask.dao.AbstractDao;
import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public abstract class AbstractDaoImpl <T extends AbstractEntity> implements AbstractDao<T>{

	protected final RowMapper<T> rowMapper;

	protected final String tableName;
	
	protected final JdbcTemplate jdbcTemplate;

	protected AbstractDaoImpl(RowMapper<T> rowMapper, String tableName,
			JdbcTemplate jdbcTemplate) {
		this.rowMapper = rowMapper;
		this.tableName = tableName;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void remove(Integer id){
		String delete = "DELETE FROM " + tableName + " WHERE id = ?";
		jdbcTemplate.update(delete, rowMapper);
	}
	
	@Override
	public T getById(Integer id) {
		Object[] params = { id };	
		String findById = "SELECT * FROM " + tableName + " WHERE id = ?";
		return jdbcTemplate.query(findById, params, rowMapper).get(0);
	}
	
	@Override
	public Collection<T> getAll() {
		String findAll = "SELECT * FROM " + tableName;
		return jdbcTemplate.query(findAll, rowMapper);
	}
}
