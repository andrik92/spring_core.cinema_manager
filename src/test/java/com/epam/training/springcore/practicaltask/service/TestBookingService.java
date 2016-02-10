package com.epam.training.springcore.practicaltask.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;

@ContextConfiguration("classpath:spring.xml")
public class TestBookingService extends AbstractJUnit4SpringContextTests {

//	@Test
//	public void testAuditoriumServiceIsDefinedAsBean() {
//		boolean contains = applicationContext.containsBean("bookingService");
//		assertTrue(contains);
//	}
//
//	@Test
//	public void testGetTicketPrice() {
//		AuditoriumService auditoriumService = applicationContext
//				.getBean(AuditoriumService.class);
//		Set<Auditorium> auditoriums = auditoriumService.getAll();
//		Auditorium auditorium = auditoriums.iterator().next();
//		auditorium.setNumberOfSeats(10);
//		auditorium.setVipSeats(new HashSet<>(Arrays.asList(1, 2, 3)));
//
//		Event event = createEvent();
//		User user = createUser();
//
//		UserService userService = applicationContext.getBean(UserService.class);
//		user = userService.save(user);
//
//		EventService eventService = applicationContext
//				.getBean(EventService.class);
//		event = eventService.save(event);
//		// Date time = event.getAirDates().first();
//		// event.assignAuditorium(time, auditorium);
//
//		BookingService bookingService = applicationContext
//				.getBean(BookingService.class);
//		bookingService.setVipSeatMultiplier(1.5);
//		bookingService.setHighRatingMultiplier(1.1);
//
//		// double price = bookingService.getTicketPrice(event, time,
//		// Arrays.asList(1,5), user);
//		// assertEquals(100*1.1 + 100*1.1*1.5, price, 0.001);
//	}
//
//	private Event createEvent() {
//		Event event = new Event();
//		event.setName("aaa");
//		event.setRaiting(EventRating.HIGH);
//		event.setBasePrice(100);
//		return event;
//	}
//
//	private User createUser() {
//		User user = new User();
//		user.setEmail("email@email.com");
//		user.setFirstName("aaa");
//		user.setLastName("bbb");
//		return user;
//	}

}
