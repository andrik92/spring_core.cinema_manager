package com.epam.training.springcore.practicaltask.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.User;

//@ContextConfiguration(classes = AppConfig.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserService extends AbstractJUnit4SpringContextTests {
	@Test
	public void testUserServiceIsDefinedAsBean() {
		boolean contains = applicationContext.containsBean("userService");
		Assert.assertTrue(contains);
	}

	@DirtiesContext
	@Test
	public void testSavingUser() {
		UserService service = applicationContext.getBean(UserService.class);
		Assert.assertNotNull(service);

		User user = createUser();

		User registered = service.register(user);
		Assert.assertNotNull(registered);
		Assert.assertNotNull(registered.getId());
		Assert.assertEquals(user, registered);
	}

	@Test
	@DirtiesContext
	public void testGetUser() {
		UserService service = applicationContext.getBean(UserService.class);
		User user = createUser();

		User registered = service.register(user);

		User byId = service.getById(registered.getId());
		Assert.assertEquals(registered, byId);

		User byEmail = service.getByEmail(registered.getEmail());
		Assert.assertEquals(registered, byEmail);
	}

	@Test
	@DirtiesContext
	public void testDeleteUser() {
		UserService service = applicationContext.getBean(UserService.class);
		User user = createUser();

		User registered = service.register(user);
		service.remove(registered);

		User byId = service.getById(registered.getId());
		Assert.assertNull(byId);
	}

	private User createUser() {
		User user = new User();
		user.setEmail("email@email.com");
		user.setFirstName("aaa");
		user.setLastName("bbb");
		return user;
	}

}
