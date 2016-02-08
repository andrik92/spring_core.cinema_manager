package com.epam.training.springcore.practicaltask.dao;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.Event;

public interface EventDao extends AbstractDao<Event>{
	
	public abstract Event getByName(String name);
	
	public boolean addSessionTime(Event event, DateTime dateTime);
	
	public boolean removeSessionTime(Event event, DateTime dateTime);
	
	public boolean eventOnDate(Event event, DateTime dateTime);
	
//	public boolean eventOnDates(Event event, SimpleDateFormat from, SimpleDateFormat to);
}
