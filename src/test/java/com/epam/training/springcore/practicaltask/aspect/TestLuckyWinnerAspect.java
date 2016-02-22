package com.epam.training.springcore.practicaltask.aspect;

import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.training.springcore.practicaltask.config.AspectConfig;
import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.entity.Event;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.service.BookingService;
import com.epam.training.springcore.practicaltask.service.EventService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLuckyWinnerAspect {
	@Configuration
	@Import(AspectConfig.class)
	@ImportResource({ "classpath:spring.xml" })
	public static class ContextConfig {
	}
	
	@Autowired
	EventService eventService;

	@Autowired
	BookingService bookingService;
	
	@Test
	public void testLuckyWinner(){
		
		Event event = new Event();
		DateTime dateTime = new DateTime();
		Properties props = new Properties();
		User user = new User();
		Ticket ticket;

		props.put("name", "Auditoria 1");
		props.put("numberOfSeats", "10");
		props.put("vip", "1,2,3");

		Auditorium auditorium = new Auditorium(props);

		Set<DateTime> sessionSet = new TreeSet<DateTime>();
		sessionSet.add(dateTime);
		event.setName("Film1");
		event.setSessionsSet(sessionSet);
		event.setBasePrice(100.00);
		eventService.assignAuditoriumToEvent(event, dateTime, auditorium);
		
		int luckyTicketsCount = 0;
		
		for (int i = 0 ; i < 100 ; i++){
			ticket = new Ticket(event, dateTime, i);			
			bookingService.bookTicket(user, ticket);
		}
		
		luckyTicketsCount = user.getLuckyTickets().size();
		
		Assert.assertTrue(luckyTicketsCount == LuckyWinnerAspect.luckyTicketsCount);
	}
}
