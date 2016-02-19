package com.epam.training.springcore.practicaltask.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CounterAspect {
	
	public static Map<String, Integer> getEventByNameCounter = new HashMap<>();

	public static Map<String, Integer> getEventPriceCounter = new HashMap<>();

	public static Map<String, Integer> bookedEventTicketCounter = new HashMap<>();

	@AfterReturning("execution(* com.epam.training.springcore.practicaltask.service.EventService.getByName(..)) && args(eventName)")
	public void countGetEventByName(String eventName) {
		increaseCount(getEventByNameCounter, eventName);
	}

//	@AfterReturning("execution(* com.epam.training.springcore.practicaltask.service.BookingService.getTicketPrice(..)) && args(event.getName())")
//	public void countGetEventTicketPrice(String eventName) {
//		increaseCount(getEventPriceCounter, eventName);
//	}

//	@AfterReturning("execution(* movie.club.app.service.BookingService.bookTicket(..)) && args(user, ticket)")
//	public void frequencyBookTricketOnEvent(User user, Ticket ticket) {
//		String eventName = ticket.getShow().getEvent().getName();
//		increaseCount(frequencyBookedPlaceForEvent, eventName);
//	}

	private void increaseCount(Map<String, Integer> mapCounter, String eventName) {
		int count = mapCounter.containsKey(eventName) ? mapCounter.get(eventName) : 0;
		mapCounter.put(eventName, ++count);
	}
}
