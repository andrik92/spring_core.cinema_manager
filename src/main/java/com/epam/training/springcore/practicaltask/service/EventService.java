package com.epam.training.springcore.practicaltask.service;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;

public interface EventService extends AbstractService<Event, EventDao> {

	public Event getEventByName (String name);
	
	public void assignAuditoriumToEvent(Event event, DateTime dateTime,
			Auditorium auditorium);

	public void removeAuditoriumAssignment(Event event, DateTime dateTime,
			Auditorium auditorium);

	public void addSessionTime(Event event, DateTime dateTime);

	public void removeSessionTime(Event event, DateTime dateTime);

}
