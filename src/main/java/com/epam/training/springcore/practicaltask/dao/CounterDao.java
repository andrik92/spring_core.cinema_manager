package com.epam.training.springcore.practicaltask.dao;

public interface CounterDao {

	public int getCountByName(String name);

	public void updateCountByName(String name);

	public void save(String name);
	
	public void deleteByName(String name);
}
