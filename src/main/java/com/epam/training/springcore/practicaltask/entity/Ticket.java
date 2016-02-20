package com.epam.training.springcore.practicaltask.entity;

import java.util.Objects;

import org.joda.time.DateTime;

public class Ticket extends AbstractEntity implements Comparable<Ticket>{

	private User user;

	private Event event;

	private DateTime dateTime;

	private Integer seat;
	
	private Double price;

	public Ticket(Event event, DateTime dateTime, Integer seat) {
		this.event = event;
		this.dateTime = dateTime;
		this.seat = seat;
	}

	public User getUser() {
		return user;
	}

	public Event getEvent() {
		return event;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, event, seat);
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
		Ticket other = (Ticket) obj;
		if (dateTime == null) {
			if (other.dateTime != null) {
				return false;
			}
		} else if (!dateTime.equals(other.dateTime)) {
			return false;
		}
		if (event == null) {
			if (other.event != null) {
				return false;
			}
		} else if (!event.equals(other.event)) {
			return false;
		}
		if (seat != other.seat) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Ticket other) {
		if (other == null) {
			return 1;
		}
		int result = dateTime.compareTo(other.getDateTime());
		
		if (result == 0) {
			result = event.getName().compareTo(other.getEvent().getName());
		}
		if (result == 0) {
			result = Integer.valueOf(seat).compareTo(other.getSeat());
		}
		return result;
	}
}