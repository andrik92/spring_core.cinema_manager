package com.epam.training.springcore.practicaltask.aspect;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.AspectConfig;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.service.BookingService;
import com.epam.training.springcore.practicaltask.service.EventService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCounterAspect {
	@Configuration
	@Import(AspectConfig.class)
	@ImportResource({ "classpath:spring.xml" })
	public static class ContextConfig {
	}

	@Autowired
	EventService eventService;

	@Autowired
	BookingService bookingService;

	@Test
	public void testGetEventByName() {

		Assert.assertNull(eventService.getEventByName("film1"));

		eventService.getEventByName("film1");
		eventService.getEventByName("film1");

		Assert.assertTrue(CounterAspect.getEventByNameCounter.get("film1") == 3);

		eventService.getEventByName("film2");

		Assert.assertTrue(CounterAspect.getEventByNameCounter.get("film2") == 1);

	}

	@Test
	public void testBookingTickets() {

		Map<String, Integer> getEventPriceCounter = CounterAspect.getEventPriceCounter;
		Map<String, Integer> bookedEventTicketCounter = CounterAspect.bookedEventTicketCounter;

		Event event = new Event();
		DateTime dateTime = new DateTime();
		Properties props = new Properties();
		User user = new User();
		Ticket ticket1 = new Ticket(event, dateTime, 1);
		Ticket ticket2 = new Ticket(event, dateTime, 2);
		Ticket ticket3 = new Ticket(event, dateTime, 3);

		props.put("name", "Auditoria 1");
		props.put("numberOfSeats", "10");
		props.put("vip", "1,2,3");

		Auditorium auditorium = new Auditorium(props);

		Set<DateTime> sessionSet = new TreeSet<DateTime>();
		sessionSet.add(dateTime);
		event.setName("Film1");
		event.setSessionsSet(sessionSet);
		eventService.assignAuditoriumToEvent(event, dateTime, auditorium);

		bookingService.getTicketPrice(event, dateTime, 5, user);
		bookingService.getTicketPrice(event, dateTime, 5, user);
		bookingService.getTicketPrice(event, dateTime, 4, user);

		Assert.assertTrue(getEventPriceCounter.get("Film1") == 3);

		bookingService.bookTicket(user, ticket1);
		bookingService.bookTicket(user, ticket2);
		bookingService.bookTicket(user, ticket3);

		Assert.assertTrue(bookedEventTicketCounter.get("Film1") == 3);
	}
}
