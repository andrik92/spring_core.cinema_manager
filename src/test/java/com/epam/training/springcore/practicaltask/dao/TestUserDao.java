package com.epam.training.springcore.practicaltask.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.epam.training.springcore.practicaltask.dao.impl.UserDaoImpl;
import com.epam.training.springcore.practicaltask.entity.User;

public class TestUserDao {

	private UserDao userDao;

	@Before
	public void setup() {
		userDao = new UserDaoImpl();

		User user = registerUser("Andriy", "Prokip", "aaa@aaa.com");
		userDao.save(user);

		user = registerUser("Maxym", "Borachok", "mmm@mmm.com");
		userDao.save(user);
	}

	@Test
	public void testSaveUser() {
		User user = registerUser("aaa", "bbb", "ccc@ccc.com");

		User savedUser = userDao.save(user);

		assertNotNull(savedUser.getId());

		assertEquals(savedUser, user);
	}

	@Test
	public void testGetUser() {
		User user = registerUser("Vika", "Naz", "vvv@vvv.com");
		User savedUser = userDao.save(user);

		assertNotNull(savedUser.getId());

		Integer id = savedUser.getId();
		Collection<User> users = userDao.getAll();
		assertFalse(users.isEmpty());
		assertTrue(users.contains(savedUser));

		User byId = userDao.getById(id);
		assertNotNull(byId);
		assertEquals(savedUser, byId);

		byId = userDao.getById(-1);
		assertNull(byId);

		User byEmail = userDao.getByEmail(user.getEmail());
		assertNotNull(byEmail);
		assertEquals(savedUser, byEmail);

		byEmail = userDao.getByEmail("zzz");
		assertNull(byEmail);
	}

	@Test
	public void testRemoveUser() {
		User user = registerUser("Vika", "Naz", "vvv@vvv.com");
		User savedUser = userDao.save(user);

		userDao.remove(savedUser.getId());

		Collection<User> users = userDao.getAll();
		assertFalse(users.isEmpty());
		assertFalse(users.contains(savedUser));
	}

	private User registerUser(String firstName, String lastName, String email) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}

}
