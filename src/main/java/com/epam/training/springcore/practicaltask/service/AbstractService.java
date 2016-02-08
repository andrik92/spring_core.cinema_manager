package com.epam.training.springcore.practicaltask.service;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.dao.AbstractDao;
import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public class AbstractService<T extends AbstractEntity, D extends AbstractDao<T>> {
	protected D dao;

	public AbstractService(D dao) {
		super();
		this.dao = dao;
	}

	public T save(T object) {
		return dao.save(object);
	}

	public void remove(T object) {
		dao.remove(object.getId());
	}

	public T getById(Integer id) {
		return dao.getById(id);
	}

	public Collection<T> getAll() {
		return dao.getAll();
	}
}
