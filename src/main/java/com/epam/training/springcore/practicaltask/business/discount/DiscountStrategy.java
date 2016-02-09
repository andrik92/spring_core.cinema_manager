package com.epam.training.springcore.practicaltask.business.discount;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.User;

public interface DiscountStrategy {
	public double calculateDiscount(User user, DateTime date);

}
