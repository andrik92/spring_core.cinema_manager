package com.epam.training.springcore.practicaltask.dao;

import com.epam.training.springcore.practicaltask.entity.User;

public interface UserDao extends AbstractDao<User>{

	public abstract User getByEmail(String email);

}
