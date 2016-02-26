package com.epam.training.springcore.practicaltask.dao;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.H2DataSourceConfig;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.jdbc.mapper.TicketRowMapper;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath:spring.xml" })
public class UserDaoTest {

	@Configuration
	// @Import(AspectConfig.class)
	@Import(H2DataSourceConfig.class)
	@ImportResource(locations = { "classpath:spring.xml" })
	public static class ContextConfig {
	}

	@Autowired
	private EmbeddedDatabase db;

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventDao eventDao;

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private TicketRowMapper ticketRowMapper;

	@Test
	public void testFindByName() {
		User user = userDao.getById(1);

		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("Andriy", user.getFirstName());
		Assert.assertEquals("and@gmail.com", user.getEmail());

		User user1 = new User();
		user1.setFirstName("TestName");
		user1.setLastName("LastName");
		user1.setEmail("email");
		user1.setBirthDate(new DateTime());

		userDao.save(user1);

		System.out.println(eventDao.getAll().toString());

		System.out.println(ticketDao.getAll().toString()
				+ "\n\n\n\n\n\n***********************************");

	}

}