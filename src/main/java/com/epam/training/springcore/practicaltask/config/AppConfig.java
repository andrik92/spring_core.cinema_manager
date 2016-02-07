package com.epam.training.springcore.practicaltask.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.dao.impl.UserDaoImpl;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.service.AuditoriumService;
import com.epam.training.springcore.practicaltask.service.UserService;

@Configuration
@PropertySource({
	"classpath:auditoriums/hall1.properties",
	"classpath:auditoriums/hall2.properties"
})
public class AppConfig {
	@Autowired
	Set<Auditorium> auditoriums;
	
	@Bean
	public AuditoriumService auditoriumService (){
		return new AuditoriumService(auditoriums);
	}
	
	@Bean
	public UserDao userDao(){
		return new UserDaoImpl();
	}

	@Bean
	public UserService userService(){
		return new UserService(userDao());
	}
	
}
