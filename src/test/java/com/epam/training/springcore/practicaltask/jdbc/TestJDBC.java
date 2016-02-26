package com.epam.training.springcore.practicaltask.jdbc;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.H2DataSourceConfig;
import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.dao.TicketDao;
import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.jdbc.dao.impl.CounterAccessByNameDaoImpl;
import com.epam.training.springcore.practicaltask.jdbc.mapper.TicketRowMapper;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJDBC {

	@Configuration
	@Import(H2DataSourceConfig.class)
	@ImportResource(locations = { "classpath:spring.xml" })
	public static class ContextConfig {
	}

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventDao eventDao;

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private TicketRowMapper ticketRowMapper;
	
	@Autowired
	private CounterAccessByNameDaoImpl counterAccessByName;

	@Test
	public void test() {
		User user = userDao.getById(1);

		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("Andriy", user.getFirstName());
		Assert.assertEquals("and@gmail.com", user.getEmail());

		User user1 = new User();
		user1.setFirstName("TestName");
		user1.setLastName("LastName");
		user1.setEmail("email");
		user1.setBirthDate(new DateTime("2016-02-26"));

		userDao.save(user1);

		Assert.assertEquals(userDao.getByName("TestName"), user1);	
		
		int count = counterAccessByName.getCountByName("film");
		
		counterAccessByName.updateCountByName("film");
		
		Assert.assertFalse(count == counterAccessByName.getCountByName("film"));
		
		Assert.assertTrue(++count == counterAccessByName.getCountByName("film"));
	}

}