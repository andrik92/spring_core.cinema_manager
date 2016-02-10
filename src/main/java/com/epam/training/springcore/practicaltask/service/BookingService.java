package com.epam.training.springcore.practicaltask.service;

import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;

public class BookingService {

	private final double VIP_FEE = 2.0;
	private final double HIGH_RATED_FEE = 1.2;

	DiscountService discountService;

	public double getTicketPrice(Event event, DateTime dateTime, Integer seat,
			User user) {
		double discount;
		double price;

		price = event.getBasePrice();

		if (event.getRaiting() == EventRating.HIGH) {
			price *= HIGH_RATED_FEE;
		}

		if (event.getAuditoriums().containsKey(dateTime)) {
			if (event.getAuditoriums().get(dateTime).getVipSeats()
					.contains(seat)) {
				price *= VIP_FEE;
			}
		} else {
			throw new IllegalArgumentException(
					"There is no event for choosen dateTime");
		}

		discount = discountService.getDiscount(user, dateTime);

		price -= price * discount;

		return price;
	}

	public Set<Ticket> getPurchasedTicketsForEvent(Event event, DateTime date) {
		if (!event.getTickets().containsKey(date)) {
			throw new IllegalArgumentException(
					"There is no event for choosen dateTime");
		}

		Set<Ticket> tickets = event.getTickets().get(date);
		Set<Ticket> bookedTickets = new TreeSet<Ticket>();
		for (Ticket ticket : tickets) {
			if (ticket.getUser() == null) {
				bookedTickets.add(ticket);
			}
		}

		return bookedTickets;
	}
	
	public void bookTicket(User user, Ticket ticket){
		ticket.setUser(user);
		user.getTickets().add(ticket);
	}

}