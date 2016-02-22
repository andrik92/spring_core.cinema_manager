package com.epam.training.springcore.practicaltask.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.AspectConfig;
import com.epam.training.springcore.practicaltask.config.H2DataSourceConfig;
import com.epam.training.springcore.practicaltask.temp.dao.UserDaoImpl;
import com.epam.training.springcore.practicaltask.temp.model.User;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

	@Configuration
//	 @Import(AspectConfig.class)
	@Import(H2DataSourceConfig.class)
//	@ImportResource({ "classpath:spring.xml" })
	public static class ContextConfig {
	}

	@Autowired
	private EmbeddedDatabase db;

	UserDao userDao;

	@Test
	public void testFindByname() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setNamedParameterJdbcTemplate(template);

		User user = userDao.findByName("mkyong");

		Assert.assertNotNull(user);
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("mkyong", user.getName());
		Assert.assertEquals("mkyong@gmail.com", user.getEmail());

	}

}