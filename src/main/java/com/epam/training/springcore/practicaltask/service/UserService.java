package com.epam.training.springcore.practicaltask.service;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public interface UserService extends AbstractService<User, UserDao> {

	public User getByEmail(String email);

	public User getByName(String firstName);

}
