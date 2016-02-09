package com.epam.training.springcore.practicaltask.business.discount;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.User;

public class LoyaltyDiscount implements DiscountStrategy {

	private final int MULTIPLE = 9;
	private final double DISCOUNT = 0.5;

	@Override
	public double calculateDiscount(User user, DateTime date) {
		int totalBuyedTickets = user.getTickets().size();
		if (totalBuyedTickets != 0 && totalBuyedTickets % MULTIPLE == 0) {
			return DISCOUNT;
		} else {
			return 0;
		}
	}
}
