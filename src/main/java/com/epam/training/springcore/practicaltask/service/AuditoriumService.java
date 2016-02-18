package com.epam.training.springcore.practicaltask.service;

import java.util.Set;

import com.epam.training.springcore.practicaltask.entity.Auditorium;

public interface AuditoriumService {

	public Set<Auditorium> getAll();

	public Auditorium getByName(String name);
}
