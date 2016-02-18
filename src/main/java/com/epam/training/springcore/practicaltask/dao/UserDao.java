package com.epam.training.springcore.practicaltask.dao;

import com.epam.training.springcore.practicaltask.entity.User;

public interface UserDao extends AbstractDao<User>{

	public User getByEmail(String email);
	
	public User getByName (String firstName);

}
