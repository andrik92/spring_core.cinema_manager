package com.epam.training.springcore.practicaltask.aspect;

import java.util.Random;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.epam.training.springcore.practicaltask.entity.Ticket;

@Aspect
public class LuckyWinnerAspect {
	
	static int luckyTicketsCount = 0;

	@Before("execution(* com.epam.training.springcore.practicaltask.service.BookingService.bookTicket(..)) && args(.., ticket)")
	public void frequencyBookTricketOnEvent(Ticket ticket) {
		if (isLucky()) {
			ticket.setPrice(0.00);
		}
	}

	private boolean isLucky() {
		int rand1 = new Random().nextInt(100);
		int rand2 = new Random().nextInt(100);

		if (rand1 == rand2) {
			luckyTicketsCount++;
			return true;
		} else {
			return false;
		}
	}
}
