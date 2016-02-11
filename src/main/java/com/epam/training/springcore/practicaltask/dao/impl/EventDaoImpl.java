package com.epam.training.springcore.practicaltask.dao.impl;

import java.util.Map.Entry;

import com.epam.training.springcore.practicaltask.dao.EventDao;
import com.epam.training.springcore.practicaltask.entity.Event;

public class EventDaoImpl extends AbstractDaoImpl<Event> implements EventDao {

	@Override
	public Event getByName(String name) {
		for (Entry<Integer, Event> entry : map.entrySet()) {
			if (name.equals(entry.getValue().getName())) {
				return entry.getValue();
			}
		}
		return null;
	}

}
