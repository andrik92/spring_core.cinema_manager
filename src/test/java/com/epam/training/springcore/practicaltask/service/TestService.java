package com.epam.training.springcore.practicaltask.service;

import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;
import com.epam.training.springcore.practicaltask.service.AuditoriumService;
import com.epam.training.springcore.practicaltask.service.BookingService;
import com.epam.training.springcore.practicaltask.service.DiscountService;
import com.epam.training.springcore.practicaltask.service.EventService;
import com.epam.training.springcore.practicaltask.service.UserService;

/*
 * Testing main functionality.
 * 
 */

@ContextConfiguration("classpath:spring.xml")
public class TestService extends AbstractJUnit4SpringContextTests {

	final DateTime TESTED_DATE = (DateTime.parse("1992/10/08",
			DateTimeFormat.forPattern("yy/dd/MM")));
	final DateTime TESTED_DATE_2 = TESTED_DATE.plusDays(2);
	
	final double EVENT_BASE_PRICE = 100.00;
	final double HIGH_RATED_EVENT_PRICE = 120.00; // 1.2 * base_price
	final double EVENT_PRICE_VIP_SEAT = 200.00; // 2 * base_price
	final double HIGH_RATEDEVENT_PRICE_VIP_SEAT = 240.00; //1.2 * 2 * base_price	

	AuditoriumService auditoriumService;
	BookingService bookingService;
	DiscountService discountService;
	EventService eventService;
	UserService userService;

	@Before
	public void setup() {
		auditoriumService = applicationContext.getBean(AuditoriumService.class);
		discountService = applicationContext.getBean(DiscountService.class);
		eventService = (EventService) applicationContext.getBean("eventService");
		userService = applicationContext.getBean(UserService.class);
		bookingService = applicationContext.getBean(BookingService.class);
		
	}

	@Test
	public void testGetBeans() {
		
		boolean contains;

		contains = applicationContext.containsBean("userDao");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("eventDao");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("ticketDao");
		Assert.assertTrue(contains);

		contains = applicationContext.containsBean("userService");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("eventService");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("auditoriumService");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("discountService");
		Assert.assertTrue(contains);
		contains = applicationContext.containsBean("bookingService");
		Assert.assertTrue(contains);
	}

	@Test
	public void testEventSessionTime() {

		Event testEvent = createEvent();

		Assert.assertEquals(testEvent.getSessionsSet().size(), 1);

		eventService.addSessionTime(testEvent, DateTime.now().plusDays(5));
		eventService.addSessionTime(testEvent, DateTime.now().plusDays(6));
		eventService.addSessionTime(testEvent, DateTime.now().plusDays(7));

		Assert.assertEquals(testEvent.getSessionsSet().size(), 4);
		Assert.assertTrue(testEvent.getSessionsSet().contains(TESTED_DATE));
		
		eventService.removeSessionTime(testEvent, TESTED_DATE);
		Assert.assertFalse(testEvent.getSessionsSet().contains(TESTED_DATE));
		
	}
	
	@Test
	public void testAssignAuditoriumToEvent() {

		Event testEvent = createEvent();
		Auditorium testAuditorium = createAuditorium();
		
		eventService.assignAuditoriumToEvent(testEvent, TESTED_DATE_2, testAuditorium);

		Assert.assertTrue(testAuditorium.getEventSchedule().contains(TESTED_DATE_2));
		Assert.assertEquals(testEvent.getAuditoriums().get(TESTED_DATE_2), testAuditorium);
		
		eventService.removeAuditoriumAssignment(testEvent, TESTED_DATE_2, testAuditorium);

		Assert.assertFalse(testAuditorium.getEventSchedule().contains(TESTED_DATE_2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAssignAuditoriumEventFail() {
		
		Event testEvent = createEvent();
		Auditorium testAuditorium = createAuditorium();
		
		eventService.assignAuditoriumToEvent(testEvent, TESTED_DATE, testAuditorium);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tastRemoveAuditoriumEventFail() {
		
		Event testEvent = createEvent();
		Auditorium testAuditorium = createAuditorium();
		
		eventService.removeAuditoriumAssignment(testEvent, TESTED_DATE_2, testAuditorium);

	}

	@Test
	public void testGetTicketPrice(){
		User testUser = createUser();
		Event testHighRatedEvent = createEvent();
		Event testEvent = createEvent();
		Auditorium testAuditorium = createAuditorium();

		eventService.assignAuditoriumToEvent(testHighRatedEvent, TESTED_DATE_2, testAuditorium);
		
		Assert.assertEquals(bookingService.getTicketPrice(testHighRatedEvent, TESTED_DATE_2, 10, testUser), HIGH_RATED_EVENT_PRICE, 0);		
		Assert.assertEquals(bookingService.getTicketPrice(testHighRatedEvent, TESTED_DATE_2, 1, testUser), HIGH_RATEDEVENT_PRICE_VIP_SEAT, 0);

		testEvent.setRaiting(EventRating.MID);
		eventService.assignAuditoriumToEvent(testEvent, TESTED_DATE_2.plus(1), testAuditorium);
		
		Assert.assertEquals(bookingService.getTicketPrice(testEvent, TESTED_DATE_2.plus(1), 10, testUser), EVENT_BASE_PRICE, 0);
		Assert.assertEquals(bookingService.getTicketPrice(testEvent, TESTED_DATE_2.plus(1), 1, testUser), EVENT_PRICE_VIP_SEAT, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBookingTicket(){
		
		User testUser = createUser();
		User testUser2 = createUser();
		Event testEvent = createEvent();
		Ticket testTicket = createTicket(testEvent, TESTED_DATE, 1);
		Ticket testTicket2 = createTicket(testEvent, TESTED_DATE, 2);
		
		bookingService.bookTicket(testUser, testTicket);
		bookingService.bookTicket(testUser2, testTicket2);				
		
		Assert.assertEquals(testTicket.getUser(),testUser);
		Assert.assertTrue(testUser.getBookedTickets().contains(testTicket));
		
		Assert.assertEquals(testTicket2.getUser(),testUser2);
		Assert.assertTrue(testUser2.getBookedTickets().contains(testTicket2));
		
		Assert.assertNotEquals(2, bookingService.getPurchasedTicketsForEvent(testEvent, TESTED_DATE).size());
		
	}
	
	
	//METHODS FOR INITIALIZATION
	
	private User createUser(){
	
		User user = new User();
		user.setEmail("mail@mail");
		user.setFirstName("Andriy");
		user.setLastName("Prokip");
		user.setBirthDate(TESTED_DATE);
		
		return user;
	}
	
	private Event createEvent(){
		Event event = new Event();

		Set<DateTime> sessionSet = new TreeSet<DateTime>();
		sessionSet.add(TESTED_DATE);

		event.setName("Panda 4DX");
		event.setRaiting(EventRating.HIGH);
		event.setSessionsSet(sessionSet);
		event.setBasePrice(EVENT_BASE_PRICE);
		
		return event;
	}
	
	private Auditorium createAuditorium(){
		Properties props = new Properties();
		props.put("name", "Auditoria 1");
		props.put("numberOfSeats", "10");
		props.put("vip", "1,2,3");
		
		Set<DateTime> eventSchedule = new TreeSet<DateTime>();
		eventSchedule.add(TESTED_DATE);
		
		Auditorium auditorium = new Auditorium(props);
		auditorium.setEventSchedule(eventSchedule);
		
		return auditorium;
	}
	
	private Ticket createTicket(Event event, DateTime dateTime,Integer seat){
		Ticket ticket = new Ticket(event, dateTime, seat);
		return ticket;
	}
}
