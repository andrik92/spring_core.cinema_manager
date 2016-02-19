package com.epam.training.springcore.practicaltask.aspect;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.AspectConfig;
import com.epam.training.springcore.practicaltask.service.EventService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
//@ContextConfiguration(classes = AspectConfig)
//public class CounterAspectTest {
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//extends AbstractJUnit4SpringContextTests
public class TestCounterAspect  {
	@Configuration
	@Import(AspectConfig.class)
	@ImportResource({ "classpath:spring.xml" })
	public static class ContextConfig {}

	@Autowired
	EventService eventService;
	
	@Test
	public void testGetEventByName() {
		Map<String, Integer> getEventByNameCounter = CounterAspect.getEventByNameCounter;
		Assert.assertNull(eventService.getEventByName("film1"));

	}
}
