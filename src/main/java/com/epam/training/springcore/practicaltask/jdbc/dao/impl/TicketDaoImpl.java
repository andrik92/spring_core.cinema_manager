package com.epam.training.springcore.practicaltask.jdbc.dao.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.training.springcore.practicaltask.dao.TicketDao;
import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.Ticket;
import com.epam.training.springcore.practicaltask.jdbc.mapper.TicketRowMapper;

public class TicketDaoImpl extends AbstractDaoImpl<Ticket> implements TicketDao {

	private final static String TABLE_NAME = "ticket";

	@Autowired
	UserDao userDao;
	
	@Autowired
	TicketRowMapper ticketRowMapper;
	
	public TicketDaoImpl(TicketRowMapper ticketRowMapper, JdbcTemplate jdbcTemplate) {
		super(ticketRowMapper, TABLE_NAME, jdbcTemplate);
	}

	@Override
	public Ticket save(Ticket ticket) {
		String insert = "INSERT INTO " + TABLE_NAME + "(userId, eventId, dateTime, seat, price) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insert, ticket.getUser().getId(), ticket.getUser().getId(), 
				new Date(ticket.getDateTime().toDate().getTime()), ticket.getSeat(), ticket.getPrice());
		return null;
	}
	
}
