package com.epam.training.springcore.practicaltask.service.impl;

import java.util.List;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.business.discount.DiscountStrategy;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.service.DiscountService;

public class DiscountServiceImpl implements DiscountService{

	private List<DiscountStrategy> discountStrategies;

	public List<DiscountStrategy> getDiscountStrategies() {
		return discountStrategies;
	}

	public void setDiscountStrategies(List<DiscountStrategy> discountStrategies) {
		this.discountStrategies = discountStrategies;
	}

	@Override
	public double getDiscount(User user, DateTime date) {

		double discount = 0;
		double currentDiscount = 0;
		
		//calculate the biggest discount
		for (DiscountStrategy currentDiscountStrategy : discountStrategies) {
			currentDiscount = currentDiscountStrategy.calculateDiscount(user, date);
			if (currentDiscount > discount){
				discount = currentDiscount;
			}
		}

		return discount;
	}

}
