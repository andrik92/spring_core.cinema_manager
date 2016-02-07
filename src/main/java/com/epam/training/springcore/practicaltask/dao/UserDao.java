package com.epam.training.springcore.practicaltask.dao;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.entity.User;

public interface UserDao {

	public abstract User save(User user);

	public abstract void remove(Integer id);

	public abstract User getById(Integer id);

	public abstract User getByEmail(String email);

//	public abstract Collection<User> getByName(String name);

	public abstract Collection<User> getAll();
}
