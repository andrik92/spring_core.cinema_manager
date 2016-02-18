package com.epam.training.springcore.practicaltask.service.impl;

import java.util.Collections;
import java.util.Set;

import com.epam.training.springcore.practicaltask.entity.Auditorium;
import com.epam.training.springcore.practicaltask.service.AuditoriumService;

public class AuditoriumServiceImpl implements AuditoriumService {

	private Set<Auditorium> auditoriums;

	public AuditoriumServiceImpl(Set<Auditorium> auditorium) {
		this.auditoriums = Collections.unmodifiableSet(auditorium);
	}

	@Override
	public Set<Auditorium> getAll() {
		return auditoriums;
	}

	@Override
	public Auditorium getByName(String name) {
		for (Auditorium auditorium : auditoriums) {
			if (name.equals(auditorium.getName())) {
				return auditorium;
			}
		}
		return null;
	}

}
