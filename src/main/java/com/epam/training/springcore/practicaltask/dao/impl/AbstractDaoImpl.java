package com.epam.training.springcore.practicaltask.dao.impl;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.epam.training.springcore.practicaltask.dao.AbstractDao;
import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public class AbstractDaoImpl<T extends AbstractEntity> implements
		AbstractDao<T> {

	private Integer IdSet = new Integer(0);
	protected final Map<Integer, T> map = new ConcurrentHashMap<Integer, T>();

	@Override
	public T save(T object) {
		if (object.getId() == null) {
			object.setId(IdSet++);
		}
		map.put(object.getId(), object);
		return object;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);

	}

	@Override
	public T getById(Integer id) {
		return map.get(id);
	}

	@Override
	public Collection<T> getAll() {
		return map.values();
	}

}
