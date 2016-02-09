package com.epam.training.springcore.practicaltask.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;

@ContextConfiguration("classpath:spring.xml")
public class TestEventService extends AbstractJUnit4SpringContextTests {

	@Test
	public void testUserServiceIsDefinedAsBean() {
		boolean contains = applicationContext.containsBean("eventService");
		assertTrue(contains);
	}

	@DirtiesContext
	@Test
	public void testSavingEvent() {
		EventService service = applicationContext.getBean(EventService.class);
		assertNotNull(service);

		Event event = createEvent();

		Event registered = service.save(event);
		assertNotNull(registered);
		assertNotNull(registered.getId());
		assertEquals(event, registered);
	}

	@Test
	@DirtiesContext
	public void testGetEvent() {
		EventService service = applicationContext.getBean(EventService.class);
		Event event = createEvent();

		Event registered = service.save(event);

		Event byId = service.getById(registered.getId());
		assertEquals(registered, byId);
	}

	@Test
	@DirtiesContext
	public void testDeleteEvent() {
		EventService service = applicationContext.getBean(EventService.class);
		Event event = createEvent();

		Event registered = service.save(event);
		service.remove(registered);

		Event byId = service.getById(registered.getId());
		assertNull(byId);
	}

	private Event createEvent() {
		Event event = new Event();
		Set<DateTime> sessionsSet = new TreeSet<>();
		sessionsSet.add(DateTime.now());
		sessionsSet.add(DateTime.now().plusDays(1));
		sessionsSet.add(DateTime.now().plusDays(2));
		event.setName("Kino");
		event.setRaiting(EventRating.HIGH);
		event.setBasePrice(100.10);
		event.setSessionsSet(sessionsSet);
		System.out.println(event.toString());
		return event;
	}

}
