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

	public void assignAuditoriumToEvent(Event event, DateTime dateTime,
			Auditorium auditorium) {
		if (auditorium.getEventSchedule().contains(dateTime)) {
			throw new IllegalArgumentException(
					"Auditorium is unable to book at this time. Auditorium is occupied.");
		}else{
			event.getAuditoriums().put(dateTime, auditorium);
			auditorium.getEventSchedule().add(dateTime);
			
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
