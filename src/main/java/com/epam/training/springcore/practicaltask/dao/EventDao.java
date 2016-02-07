package com.epam.training.springcore.practicaltask.dao;

import java.util.Date;

import com.epam.training.springcore.practicaltask.entity.Event;

public interface EventDao extends AbstractDao<Event>{
	
	public abstract Event getByName(String name);
	
	public boolean addSessionTime(Event event, Date dateTime);
	
	public boolean removeSessionTime(Event event, Date dateTime);
	
	public boolean eventOnDate(Event event, Date dateTime);
	
//	public boolean eventOnDates(Event event, SimpleDateFormat from, SimpleDateFormat to);
}
