package com.epam.training.springcore.practicaltask.dao;

import com.epam.training.springcore.practicaltask.entity.Event;

public interface EventDao extends AbstractDao<Event> {

	public abstract Event getByName(String name);

}
