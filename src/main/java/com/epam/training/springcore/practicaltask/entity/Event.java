package com.epam.training.springcore.practicaltask.entity;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Event extends AbstractEntity {

	private String name;
	private Set<Date> sessionsSet = new TreeSet<>();
	private double basePrice;
	private EventRating raiting;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Date> getSessionsSet() {
		return sessionsSet;
	}

	public void setSessionsSet(Set<Date> sessionsSet) {
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

	private Map<Date, Auditorium> auditoriums = new TreeMap<>();

	public boolean assignAuditorium(Date dateTime, Auditorium auditorium) {
		if (sessionsSet.contains(dateTime)) {
			auditoriums.put(dateTime, auditorium);
			return true;
		} else {
			return false;
		}
	}

	public boolean addSessionTime(Date dateTime) {
		return sessionsSet.add(dateTime);
	}

	public boolean removeAuditoriumAssignment(Date dateTime) {
		return auditoriums.remove(dateTime) != null;
	}
}
