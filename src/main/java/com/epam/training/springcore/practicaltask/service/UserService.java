package com.epam.training.springcore.practicaltask.service;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public class UserService extends AbstractService<User, UserDao> {

	private UserDao userDao;

	public UserService(UserDao dao) {
		super(dao);
	}

	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	public User getByName(String firstName) {
		return userDao.getByName(firstName);
	}

}
