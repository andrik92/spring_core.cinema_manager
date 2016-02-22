package com.epam.training.springcore.practicaltask.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;

import com.epam.training.springcore.practicaltask.dao.TicketDao;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;
import com.epam.training.springcore.practicaltask.service.BookingService;

public class BookingServiceImpl implements BookingService {

	private final double VIP_FEE = 2.0;
	private final double HIGH_RATED_FEE = 1.2;

	DiscountServiceImpl discountService;
	TicketDao ticketDao;

	public void setDiscountService(DiscountServiceImpl discountService) {
		this.discountService = discountService;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
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

	@Override
	public Set<Ticket> getPurchasedTicketsForEvent(Event event,
			DateTime dateTime) {
		Set<Ticket> purchasedTicketsOnEventSession = new TreeSet<Ticket>();

		for (Ticket ticket : ticketDao.getAll()) {
			if (ticket.getEvent().equals(event)) {
				if (ticket.getDateTime().equals(dateTime)) {
					purchasedTicketsOnEventSession.add(ticket);
				}
			}
		}

		return purchasedTicketsOnEventSession;
	}

	@Override
	public void bookTicket(User user, Ticket ticket) {
//		double price = getTicketPrice(ticket.getEvent(), ticket.getDateTime(), ticket.getSeat(), user);
//		ticket.setPrice(price);
		ticket.setUser(user);
		user.getBookedTickets().add(ticket);
	}

}