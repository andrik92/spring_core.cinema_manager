package com.epam.training.springcore.practicaltask.service;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.User;

@ContextConfiguration("classpath:spring.xml")
public class TestDiscountService extends AbstractJUnit4SpringContextTests {

	@Test
	public void testDiscountServiceIsDefinedAsBean() {
		boolean contains = applicationContext.containsBean("discountService");
		Assert.assertTrue(contains);
	}

	@Test	
	public void testDiscountService() {
		DiscountService discountService = applicationContext.getBean(DiscountService.class);
		User user = createUser();
		
		Assert.assertEquals(0.05, discountService.getDiscount(user, DateTime.now()),0);
		Assert.assertNotEquals(0.05, discountService.getDiscount(user, DateTime.now().plusDays(1)));		
	}

	private User createUser() {
		User user = new User();
		user.setBirthDate(DateTime.now());
		return user;
	}
}