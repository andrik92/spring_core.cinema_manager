package com.epam.training.springcore.practicaltask.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;

@Aspect
public class CounterAspect {
	
	public static Map<String, Integer> getEventByNameCounter = new HashMap<>();

	public static Map<String, Integer> getEventPriceCounter = new HashMap<>();

	public static Map<String, Integer> bookedEventTicketCounter = new HashMap<>();

	@AfterReturning("execution(* com.epam.training.springcore.practicaltask.service.EventService.getEventByName(..)) && args(eventName)")
	public void countGetEventByName(String eventName) {
		increaseCount(getEventByNameCounter, eventName);
	}

	@AfterReturning("execution(* com.epam.training.springcore.practicaltask.service.BookingService.getTicketPrice(..)) && args(event,..)")
	public void countGetEventTicketPrice(Event event) {
		increaseCount(getEventPriceCounter, event.getName());
	}

	@AfterReturning("execution(* com.epam.training.springcore.practicaltask.service.BookingService.bookTicket(..)) && args(.., ticket)")
	public void frequencyBookTricketOnEvent(Ticket ticket) {
		increaseCount(bookedEventTicketCounter, ticket.getEvent().getName());
	}

	private void increaseCount(Map<String, Integer> mapCounter, String eventName) {
		int count = mapCounter.containsKey(eventName) ? mapCounter.get(eventName) : 0;
		mapCounter.put(eventName, ++count);
	}
}
