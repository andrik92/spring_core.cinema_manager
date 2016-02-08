package com.epam.training.springcore.practicaltask.service;

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
		boolean result = event.assignAuditorium(dateTime, auditorium);
		if (result) {
			dao.save(event);
		}
		return result;
	}
}
