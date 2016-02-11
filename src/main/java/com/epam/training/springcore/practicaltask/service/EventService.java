package com.epam.training.springcore.practicaltask.service;

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
		} else {
			event.getAuditoriums().put(dateTime, auditorium);
			auditorium.getEventSchedule().add(dateTime);
		}

	}

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

	public void addSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().contains(dateTime)) {
			throw new IllegalArgumentException("Such dateTime already exist.");
		} else {
			event.getSessionsSet().add(dateTime);
		}
	}

	public void removeSessionTime(Event event, DateTime dateTime) {
		if (event.getSessionsSet().contains(dateTime)) {
			event.getSessionsSet().remove(dateTime);
		} else {
			throw new IllegalArgumentException(
					"Such date is not found in sessionDate.");
		}
	}
}
