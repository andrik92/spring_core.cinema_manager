package com.epam.training.springcore.practicaltask.entity;

import java.util.Set;
import java.util.TreeSet;

public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private Set<Ticket> tickets = new TreeSet<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
