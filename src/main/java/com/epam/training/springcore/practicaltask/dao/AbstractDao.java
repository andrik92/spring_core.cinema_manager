package com.epam.training.springcore.practicaltask.dao;

import java.util.Collection;

import com.epam.training.springcore.practicaltask.entity.AbstractEntity;

public interface AbstractDao<T extends AbstractEntity> {

	public abstract T save(T object);

	public abstract void remove(Integer id);

	public abstract T getById(Integer id);

	public abstract Collection<T> getAll();

}
