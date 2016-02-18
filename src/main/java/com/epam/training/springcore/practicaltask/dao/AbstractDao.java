package com.epam.training.springcore.practicaltask.dao;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public interface AbstractDao<T extends AbstractEntity> {

	public T save(T object);

	public void remove(Integer id);

	public T getById(Integer id);

	public Collection<T> getAll();

}
