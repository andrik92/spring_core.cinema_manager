package com.epam.training.springcore.practicaltask.service;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User register (User user){
		return userDao.save(user);
	}
	
	public void remove(User user) {
		userDao.remove(user.getId());
	}
	
	public User getById(Integer id){
		return userDao.getById(id);
	}

	public User getByEmail(String email){
		return userDao.getByEmail(email);
	}

//	public Collection<User> getByName(String name)
//	public abstract Collection<User> getAll()

}
