package com.epam.training.springcore.practicaltask.service.impl;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.service.EventService;

public class EventServiceImpl extends AbstractServiceImpl<Event, EventDao> implements EventService{

	public EventServiceImpl(EventDao dao) {
		super(dao);
	}

	@Override
	public Event getEventByName(String name) {
		return dao.getByName(name);
	}	
	
	@Override
	public void assignAuditoriumToEvent(Event event, DateTime dateTime,
			Auditorium auditorium) {

		if (auditorium.getEventSchedule().contains(dateTime)) {
			throw new IllegalArgumentException(
					"Auditorium is unable to book at this time. Auditorium is occupied.");
		} else {
			event.getAuditoriums().put(dateTime, auditorium);
			auditorium.getEventSchedule().add(dateTime);
		}

	}

	@Override
	public void removeAuditoriumAssignment(Event event, DateTime dateTime,
			Auditorium auditorium) {
		if (event.getAuditoriums().get(dateTime) != null) {
			event.getAuditoriums().remove(dateTime);
			auditorium.getEventSchedule().remove(dateTime);
		} else {
			throw new IllegalArgumentException(
					"Chosen Auditorium is not assign for this Event for choosen Date.");
		}
	}

	@Override
	public void addSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().contains(dateTime)) {
			throw new IllegalArgumentException("Such dateTime already exist.");
		} else {
			event.getSessionsSet().add(dateTime);
		}
	}

	@Override
	public void removeSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().contains(dateTime)) {
			event.getSessionsSet().remove(dateTime);
		} else {
			throw new IllegalArgumentException(
					"Such date is not found in sessionDate.");
		}
	}

}
