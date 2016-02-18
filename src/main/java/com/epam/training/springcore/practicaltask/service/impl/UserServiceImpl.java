package com.epam.training.springcore.practicaltask.service.impl;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.service.UserService;

public class UserServiceImpl extends AbstractServiceImpl<User, UserDao> implements UserService{

	public UserServiceImpl(UserDao dao) {
		super(dao);
	}

	@Override
	public User getByEmail(String email) {
		return dao.getByEmail(email);
	}

	@Override
	public User getByName(String firstName) {
		return dao.getByName(firstName);
	}

}
