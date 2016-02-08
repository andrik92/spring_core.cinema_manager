package com.epam.training.springcore.practicaltask.entity;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.enumeration.EventRating;

public class Event extends AbstractEntity {

	private String name;
	private Set<DateTime> sessionsSet = new TreeSet<>();
	private double basePrice;
	private EventRating raiting;
	private Map<DateTime, Auditorium> auditoriums = new TreeMap<>();
	private Set<Ticket> tickets = new TreeSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DateTime> getSessionsSet() {
		return sessionsSet;
	}

	public void setSessionsSet(Set<DateTime> sessionsSet) {
		this.sessionsSet = sessionsSet;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public EventRating getRaiting() {
		return raiting;
	}

	public void setRaiting(EventRating raiting) {
		this.raiting = raiting;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public boolean assignAuditorium(DateTime dateTime, Auditorium auditorium) {
		if (sessionsSet.contains(dateTime)) {
			auditoriums.put(dateTime, auditorium);
			return true;
		} else {
			return false;
		}
	}

	public boolean addSessionTime(DateTime dateTime) {
		return sessionsSet.add(dateTime);
	}

	public boolean removeAuditoriumAssignment(Date dateTime) {
		return auditoriums.remove(dateTime) != null;
	}
}
