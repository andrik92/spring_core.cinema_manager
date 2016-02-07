package com.epam.training.springcore.practicaltask.dao.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;

public class UserDaoImpl implements UserDao {

	private Integer IdSet = new Integer(0);
	private final Map<Integer, User> userMap = new ConcurrentHashMap<Integer, User>();

	public User save(User user) {
		if (user.getId()==null) {
			user.setId(IdSet++);
		}
		userMap.put(user.getId(), user);
		return user;
	}

	public void remove(Integer id) {
		userMap.remove(id);
	}

	public User getById(Integer id) {
		return userMap.get(id);
	}

	public User getByEmail(String email) {
		for (Entry<Integer, User> entry : userMap.entrySet()) {
			if (email.equals(entry.getValue().getEmail())) {
				return entry.getValue();
			}
		}
		return null;
	}

	// public Collection<User> getByName(String name) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public Collection<User> getAll() {
		return userMap.values();
	}

}
