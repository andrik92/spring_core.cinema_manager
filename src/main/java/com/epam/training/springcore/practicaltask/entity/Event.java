package com.epam.training.springcore.practicaltask.entity;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.enumeration.EventRating;

public class Event extends AbstractEntity {

	private String name;
	private double basePrice;
	private EventRating rating;
	private Set<DateTime> sessionsSet = new TreeSet<>();
	private Map<DateTime, Auditorium> auditoriums = new TreeMap<>();

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

	public EventRating getRating() {
		return rating;
	}

	public void setRating(EventRating raiting) {
		this.rating = raiting;
	}

	public Map<DateTime, Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Map<DateTime, Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", basePrice=" + basePrice
				+ ", raiting=" + rating + ", sessionsSet=" + sessionsSet
				+ ", auditoriums=" + auditoriums + ", tickets=]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Event other = (Event) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
