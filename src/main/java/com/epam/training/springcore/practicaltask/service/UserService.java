package com.epam.training.springcore.practicaltask.service;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public class UserService extends AbstractService<User, UserDao> {

	public UserService(UserDao dao) {
		super(dao);
	}

	public User getByEmail(String email) {
		return dao.getByEmail(email);
	}

	public User getByName(String firstName) {
		return dao.getByName(firstName);
	}

}
