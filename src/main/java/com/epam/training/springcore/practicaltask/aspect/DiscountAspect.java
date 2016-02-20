package com.epam.training.springcore.practicaltask.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.epam.training.springcore.practicaltask.entity.User;

@Aspect
public class DiscountAspect {

	public final static String BIRSTHDAY_DISCOUNT = "Birthday_discount";
	public final static String LOYALTY_DISCOUNT =  "Loyalty_discount";

	public static Map<String, Integer> countDiscount = new HashMap<String, Integer>();
	public static Map<User, Integer> countDiscountperUser = new HashMap<User, Integer>();

	@AfterReturning(pointcut = "execution(* com.epam.training.springcore.practicaltask.business.discount.BirthdayDiscount.calculateDiscount(..))", returning = "returnVal")
	public void countBirthdayDiscount(double returnVal) {
		if (returnVal != 0) {
			increaseCount(countDiscount, BIRSTHDAY_DISCOUNT);
		}
	}

	@AfterReturning(pointcut = "execution(* com.epam.training.springcore.practicaltask.business.discount.LoyaltyDiscount.calculateDiscount(..))", returning = "returnVal")
	public void countLoyaltyDiscount(double returnVal) {
		if (returnVal != 0) {
			increaseCount(countDiscount, LOYALTY_DISCOUNT);
		}
	}

	@AfterReturning(pointcut = "execution(* com.epam.training.springcore.practicaltask.business.discount.DiscountStrategy.calculateDiscount(..))&& args(user,..)", returning = "returnVal")
	public void countBirthdayDiscountPerUser(User user, double returnVal) {
		if (returnVal != 0) {
			int count = countDiscountperUser.containsKey(user) ? countDiscountperUser.get(user) : 0;
			countDiscountperUser.put(user, ++count);
		}
	}

	private void increaseCount(Map<String, Integer> mapCounter,
			String discountName) {
		int count = mapCounter.containsKey(discountName) ? mapCounter
				.get(discountName) : 0;
		mapCounter.put(discountName, ++count);
	}

}
