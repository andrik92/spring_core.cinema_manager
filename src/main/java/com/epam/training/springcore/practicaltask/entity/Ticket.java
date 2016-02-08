package com.epam.training.springcore.practicaltask.entity;

import org.joda.time.DateTime;

public class Ticket extends AbstractEntity {

	private User user;

	private Event event;

	private DateTime dateTime;

	private long seat;

	public Ticket(User user, Event event, DateTime dateTime, long seat) {
		this.user = user;
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

	public long getSeat() {
		return seat;
	}
}