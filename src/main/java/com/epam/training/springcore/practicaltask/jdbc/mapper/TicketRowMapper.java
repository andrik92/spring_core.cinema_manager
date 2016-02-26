package com.epam.training.springcore.practicaltask.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.dao.UserDao;
import com.epam.training.springcore.practicaltask.entity.Ticket;

public class TicketRowMapper implements RowMapper<Ticket> {

	@Autowired
	UserDao userDao;

	@Autowired
	EventDao eventDao;

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {

		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt("id"));
		ticket.setUser(userDao.getById(rs.getInt("userId")));
		ticket.setEvent(eventDao.getById(rs.getInt("eventId")));
		ticket.setDateTime(new DateTime(rs.getDate("dateTime")));
		ticket.setSeat(rs.getInt("seat"));

		return ticket;
	}

}
