package com.epam.training.springcore.practicaltask.service;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.dao.AbstractDao;
import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity, D extends AbstractDao<T>> {
	
	public T save(T object);

	public void remove(T object);

	public T getById(Integer id);

	public Collection<T> getAll();
}
