package com.epam.training.springcore.practicaltask.business.discount;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.User;

public class BirthdayDiscount implements DiscountStrategy {

	private final double DISCOUNT = 0.05;

	@Override
	public double calculateDiscount(User user, DateTime date) {
		boolean isBirthday;
	
		if (user.getBirthDate()==null){
			return 0;
		}
		
		isBirthday = user.getBirthDate().getDayOfMonth() == date.getDayOfMonth()
				&& user.getBirthDate().getMonthOfYear() == date.getMonthOfYear();

		if (isBirthday) {
			return DISCOUNT;
		} else
			return 0;
	}
}
