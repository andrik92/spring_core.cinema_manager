package com.epam.training.springcore.practicaltask.dao.impl;

import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	@Override
	public User getByName(String firstName) {
		for (Entry<Integer, User> entry : map.entrySet()) {
			if (firstName.equals(entry.getValue().getEmail())) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for (Entry<Integer, User> entry : map.entrySet()) {
			if (email.equals(entry.getValue().getEmail())) {
				return entry.getValue();
			}
		}
		return null;
	}

}
