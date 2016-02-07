package com.epam.training.springcore.practicaltask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.dao.impl.UserDaoImpl;
import com.epam.training.springcore.practicaltask.service.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDao(){
		return new UserDaoImpl();
	}

	@Bean
	public UserService userService(){
		return new UserService(userDao());
	}
}
