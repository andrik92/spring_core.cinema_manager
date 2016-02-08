package com.epam.training.springcore.practicaltask.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.epam.training.springcore.practicaltask.dao.impl.EventDaoImpl;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;

public class TestEventDao {

	private EventDao eventDao;
	private Event event;

	@Before
	public void setup() {
		eventDao = new EventDaoImpl();
		event = new Event();
		event.setBasePrice(20.5);
		event.setName("Aaa");
		event.setRaiting(EventRating.MID);

		Set<DateTime> sessionsSet = new TreeSet<>();

		DateTime date = new DateTime();
		sessionsSet.add(date);
		sessionsSet.add(date.plusMonths(1));
		event.setSessionsSet(sessionsSet);

		eventDao.save(event);

	}

	@Test
	public void testAddRemoveAirDates() {
		int size = event.getSessionsSet().size();

		DateTime date = new DateTime();

		eventDao.addSessionTime(event, date);

		assertEquals(size + 1, event.getSessionsSet().size());
		assertTrue(eventDao.eventOnDate(event, date));

		eventDao.removeSessionTime(event, date);

		assertEquals(size, event.getSessionsSet().size());
		assertFalse(eventDao.eventOnDate(event, date));
	}
}
