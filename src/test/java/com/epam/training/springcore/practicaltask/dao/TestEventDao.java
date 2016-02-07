package com.epam.training.springcore.practicaltask.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import com.epam.training.springcore.practicaltask.dao.impl.EventDaoImpl;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.EventRating;

public class TestEventDao {

	private EventDao eventDao;
	private Event event;
	
	@Before
	public void setup(){
		eventDao = new EventDaoImpl();
		event = new Event();
		event.setBasePrice(20.5);
		event.setName("Aaa");
		event.setRaiting(EventRating.MID);
		
		Set<Date> sessionsSet = new TreeSet<>();
		
		Date date = new Date();
		sessionsSet.add(date);
		date.setDate(date.getMonth()+1);
		sessionsSet.add(date);
		event.setSessionsSet(sessionsSet);
		
		eventDao.save(event);
		
	}
	@Test
	public void testAddRemoveAirDates() {
		int size = event.getSessionsSet().size();
				
		Date date = new Date(100, 10, 10);
		
		eventDao.addSessionTime(event, date);
		
		assertEquals(size+1, event.getSessionsSet().size());
		assertTrue(eventDao.eventOnDate(event, date));
		
		eventDao.removeSessionTime(event, date);
		
		assertEquals(size, event.getSessionsSet().size());
		assertFalse(eventDao.eventOnDate(event, date));		
	}
	
		
}
