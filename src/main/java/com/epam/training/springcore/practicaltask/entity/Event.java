package com.epam.training.springcore.practicaltask.entity;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.enumeration.EventRating;

public class Event extends AbstractEntity {

	private String name;
	private double basePrice;
	private EventRating raiting;
	private Set<DateTime> sessionsSet = new TreeSet<>();
	private Map<DateTime, Auditorium> auditoriums = new TreeMap<>();
	private Map<DateTime, Set<Ticket>> tickets = new TreeMap<>();

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

//	public Set<Ticket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(Set<Ticket> tickets) {
//		this.tickets = tickets;
//	}
	
	public Map<DateTime, Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Map<DateTime, Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	public Map<DateTime, Set<Ticket>> getTickets() {
		return tickets;
	}

	public void setTickets(Map<DateTime, Set<Ticket>> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", basePrice=" + basePrice
				+ ", raiting=" + raiting + ", sessionsSet=" + sessionsSet
				+ ", auditoriums=" + auditoriums;
	}
	
	

}
