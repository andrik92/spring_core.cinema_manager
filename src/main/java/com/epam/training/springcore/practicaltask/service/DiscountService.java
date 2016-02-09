package com.epam.training.springcore.practicaltask.service;

import java.util.List;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.business.discount.DiscountStrategy;
import com.epam.training.springcore.practicaltask.entity.User;

public class DiscountService {

	private List<DiscountStrategy> discountStrategies;

	public List<DiscountStrategy> getDiscountStrategies() {
		return discountStrategies;
	}

	public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
		this.discountStrategies = discountStrategies;
	}

	public double getDiscount(User user, DateTime date) {

		double discount = 0;

		for (DiscountStrategy currentDiscountStrategy : discountStrategies) {
			discount += currentDiscountStrategy.calculateDiscount(user, date);
		}

		return discount;
	}

}
