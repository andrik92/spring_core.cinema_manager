package com.epam.training.springcore.practicaltask.service;

import java.util.Date;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;

public class EventService extends AbstractService<Event, EventDao> {

	public EventService(EventDao dao) {
		super(dao);
	}

	public boolean assignAuditoriumToEvent(Event event, DateTime dateTime,
			Auditorium auditorium) {

		if (event.getSessionsSet().contains(dateTime)) {
			event.getAuditoriums().put(dateTime, auditorium);
			dao.save(event);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeAuditoriumAssignment(Event event, Date dateTime,
			Auditorium auditorium) {
		if (event.getAuditoriums().remove(dateTime) != null) {
			dao.save(event);
			return true;
		} else {
			return false;
		}
	}

	public boolean addSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().add(dateTime)) {
			dao.save(event);
			return true;
		}

		return false;
	}

	public boolean removeSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().remove(dateTime)) {
			dao.save(event);
			return true;
		}

		return false;
	}
}
