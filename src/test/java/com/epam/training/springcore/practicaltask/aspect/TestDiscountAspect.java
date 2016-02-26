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
import com.epam.training.springcore.practicaltask.entity.User;
import com.epam.training.springcore.practicaltask.enumeration.EventRating;
import com.epam.training.springcore.practicaltask.service.BookingService;
import com.epam.training.springcore.practicaltask.service.EventService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDiscountAspect {
	@Configuration
	@Import(AspectConfig.class)
	@ImportResource({ "classpath:spring.xml" })
	public static class ContextConfig {
	}

	@Autowired
	BookingService bookingService;
	@Autowired
	EventService eventService;

	@Test
	public void testCountDiscount() {

		User user = new User();
		User user2 = new User();

		DateTime dateTime = new DateTime();
		Event event = new Event();
		Set<DateTime> sessionSet = new TreeSet<DateTime>();
		Properties props = new Properties();

		sessionSet.add(dateTime);

		props.put("name", "Auditoria 1");
		props.put("numberOfSeats", "10");
		props.put("vip", "1,2,3");

		Auditorium auditorium = new Auditorium(props);

		event.setName("film1");
		event.setRating(EventRating.HIGH);
		event.setBasePrice(100.00);
		event.setSessionsSet(sessionSet);

		user.setBirthDate(dateTime);
		user2.setBirthDate(dateTime.plusDays(1));

		eventService.assignAuditoriumToEvent(event, dateTime, auditorium);

		bookingService.getTicketPrice(event, dateTime, 5, user);
		bookingService.getTicketPrice(event, dateTime, 1, user2);

		Assert.assertTrue(DiscountAspect.countDiscount.get(DiscountAspect.BIRSTHDAY_DISCOUNT) == 1);
		Assert.assertTrue(DiscountAspect.countDiscountperUser.get(user) == 1);
		Assert.assertNull(DiscountAspect.countDiscountperUser.get(user2));

	}
}
