package com.epam.training.springcore.practicaltask.entity;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;

public class Auditorium {

	private String name;

	private int numberOfSeats;

	private Set<Integer> vipSeats;

	private Set<DateTime> eventSchedule = new TreeSet<DateTime>();;

	public Auditorium(Properties props) {
		name = props.getProperty("name");
		numberOfSeats = Integer.valueOf(props.getProperty("numberOfSeats", "0"));
				
		String vips = props.getProperty("vip", null);
		if (vips != null) {
			Set<Integer> vipsSet = new TreeSet<>();
			for (String vip : vips.split(",")) {
				vipsSet.add(Integer.parseInt(vip));
			}
			vipSeats = vipsSet;
		} else {
			vipSeats = Collections.emptySet();
		}
		if (name == null || numberOfSeats == 0) {
			throw new IllegalArgumentException(
					"Auditorium name or seats number is not passed. Expected properties 'name' and 'numberOfSeats'.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Set<Integer> getVipSeats() {
		return vipSeats;
	}

	public void setVipSeats(Set<Integer> vipSeats) {
		this.vipSeats = vipSeats;
	}
	
	public Set<DateTime> getEventSchedule() {
		return eventSchedule;
	}

	public void setEventSchedule(Set<DateTime> eventSchedule) {
		this.eventSchedule = eventSchedule;
	}

	@Override
	public String toString() {
		return "Auditorium [name=" + name + ", numberOfSeats=" + numberOfSeats
				+ ", vipSeats=" + vipSeats + ", eventSchedule=" + eventSchedule
				+ "]";
	}
	
	

}
