package com.epam.training.springcore.practicaltask.entity;

import java.util.Date;

public class Ticket extends AbstractEntity {

	private User user;

	private Event event;

	private Date dateTime;

	private long seat;

	public Ticket(User user, Event event, Date dateTime, long seat) {
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

	public Date getDateTime() {
		return dateTime;
	}

	public long getSeat() {
		return seat;
	}
}