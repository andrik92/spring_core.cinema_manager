package com.epam.training.springcore.practicaltask.service;

import java.util.Collections;
import java.util.Set;

import com.epam.training.springcore.practicaltask.entity.Auditorium;

public class AuditoriumService {
	// private Set<Auditorium> auditoriums;
	//
	// public AuditoriumService(Set<Auditorium> auditorium) {
	// this.auditoriums = Collections.unmodifiableSet(auditorium);
	// }
	//
	// public Set<Auditorium> getAll() {
	// return auditoriums;
	// }
	//

	private Set<Auditorium> auditoriums;

	public AuditoriumService(Set<Auditorium> auditorium) {
		this.auditoriums = Collections.unmodifiableSet(auditorium);
	}

	public Set<Auditorium> getAll() {
		return auditoriums;
	}

	public Auditorium getByName(String name) {
		for (Auditorium auditorium : auditoriums) {
			if (name.equals(auditorium.getName())) {
				return auditorium;
			}
		}

		return null;
	}

}
