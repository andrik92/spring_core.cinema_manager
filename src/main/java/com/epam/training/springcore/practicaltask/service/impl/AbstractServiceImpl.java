package com.epam.training.springcore.practicaltask.service.impl;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.dao.AbstractDao;
import com.epam.training.springcore.practicaltask.entity.AbstractEntity;
import com.epam.training.springcore.practicaltask.service.AbstractService;

public class AbstractServiceImpl<T extends AbstractEntity, D extends AbstractDao<T>> implements AbstractService<T, D>{
	
	protected D dao;

	public AbstractServiceImpl(D dao) {
		super();
		this.dao = dao;
	}

	@Override
	public T save(T object) {
		return dao.save(object);
	}

	@Override
	public void remove(T object) {
		dao.remove(object.getId());
	}

	@Override
	public T getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Collection<T> getAll() {
		return dao.getAll();
	}
}
