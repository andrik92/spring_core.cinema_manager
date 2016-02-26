package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import java.sql.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.jdbc.mapper.JodaTimeSavvyBeanPropertyRowMapper;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao{
	
	private final static String TABLE_NAME = "users";

	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super(new JodaTimeSavvyBeanPropertyRowMapper<User>(User.class), TABLE_NAME, jdbcTemplate);
	}


	@Override
	public User save(User user) {
		String insert = "INSERT INTO " + TABLE_NAME + "(firstName, lastName, birthDate, email) values (?, ?, ?, ?)";
		jdbcTemplate.update(insert, user.getFirstName(), user.getLastName(), 
				new Date(user.getBirthDate().toDate().getTime()), user.getEmail());
		return null;
	}

	@Override
	public User getByEmail(String email) {
		Object[] params = {email};
		String findByEmail = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";
		return jdbcTemplate.query(findByEmail, params, rowMapper).get(0);
	}

	@Override
	public User getByName(String firstName) {
		Object[] params = {firstName};
		String findByFirstName = "SELECT * FROM " + TABLE_NAME + " WHERE firstName = ?";
		return jdbcTemplate.query(findByFirstName, params, rowMapper).get(0);
	}
	
}
