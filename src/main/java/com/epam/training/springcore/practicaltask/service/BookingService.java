package com.epam.training.springcore.practicaltask.service;

import java.util.Set;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;

public interface BookingService {

	public double getTicketPrice(Event event, DateTime dateTime, Integer seat,
			User user);
	
	public Set<Ticket> getPurchasedTicketsForEvent(Event event,
			DateTime dateTime);
	
	public void bookTicket(User user, Ticket ticket);
}