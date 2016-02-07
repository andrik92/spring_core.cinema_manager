package com.epam.training.springcore.practicaltask.entity;

public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

}
