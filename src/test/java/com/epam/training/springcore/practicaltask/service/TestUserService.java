package com.epam.training.springcore.practicaltask.service;

import java.util.Collection;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.User;

@ContextConfiguration("classpath:spring.xml")
public class TestUserService extends AbstractJUnit4SpringContextTests {

	@Test
	public void testUserServiceIsDefinedAsBean() {
		boolean contains = applicationContext.containsBean("userService");
		Assert.assertTrue(contains);
	}

	@Test
	public void testRegisterUser() {
		UserService service = applicationContext.getBean(UserService.class);
		Assert.assertNotNull(service);

		User user = createUser();

		User registered = service.save(user);

		Assert.assertNotNull(registered);
		Assert.assertNotNull(registered.getId());
		Assert.assertEquals(user, registered);
	}

	@Test
	public void testGetUser() {
		UserService service = applicationContext.getBean(UserService.class);
		User user = createUser();

		User registered = service.save(user);

		User byId = service.getById(registered.getId());
		Assert.assertEquals(registered, byId);

		User byEmail = service.getByEmail(registered.getEmail());

		Assert.assertEquals(registered, byEmail);

		Collection<User> users = service.getAll();
		Assert.assertFalse(users.isEmpty());
		Assert.assertTrue(users.contains(registered));
	}

	@Test
	public void testRemoveUser() {
		UserService service = applicationContext.getBean(UserService.class);
		User user = createUser();

		User registered = service.save(user);
		service.remove(registered);

		User byId = service.getById(registered.getId());
		Assert.assertNull(byId);
	}

	private User createUser() {
		User user = new User();
		user.setEmail("mail@mail.com");
		user.setFirstName("Andriy");
		user.setLastName("Prokip");
		user.setBirthDate(DateTime.parse("1992/10/08",
				DateTimeFormat.forPattern("yy/dd/MM")));
		return user;
	}
}
