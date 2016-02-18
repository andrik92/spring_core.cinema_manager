package com.epam.training.springcore.practicaltask.service;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.User;

public interface DiscountService {

	public double getDiscount(User user, DateTime date);
	
}
