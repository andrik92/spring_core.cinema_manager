package com.epam.training.springcore.practicaltask.service;

import java.util.Date;
import java.util.List;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.dao.impl.EventDaoImpl;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.EventRating;
import com.epam.training.springcore.practicaltask.entity.User;

public class BookingService {
	
	private double vipSeatMultiplier = 1;
	
	private double highRatingMultiplier = 1;
	
	public double getTicketPrice(Event event, Date dateTime, List<Long> seats, User user) {
		EventDao eventDao = new EventDaoImpl();
		
		if (eventDao.eventOnDate(event, dateTime)) {
			
			double priceBase = event.getBasePrice();
			
			if (EventRating.HIGH == event.getRaiting()) {
				priceBase *= highRatingMultiplier;
			}
			
			long basicCount = seats.size();
			
			double priceVipSeats = priceBase * vipSeatMultiplier;
			double priceBasicSeats = priceBase * basicCount;
			
			double price = priceVipSeats + priceBasicSeats;
			
			return price;
		}
		
		return -1;
	}

	public void setVipSeatMultiplier(double vipSeatMultiplier) {
		this.vipSeatMultiplier = vipSeatMultiplier;
	}

	public void setHighRatingMultiplier(double highRatingMultiplier) {
		this.highRatingMultiplier = highRatingMultiplier;
	}

}