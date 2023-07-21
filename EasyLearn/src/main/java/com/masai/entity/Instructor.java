package com.masai.entity;

import jakarta.persistence.Entity;

@Entity
public class Instructor extends User{
	public Instructor() {
		super();
	}

	public Instructor(String username, String password, String name, State accountStatus) {
		super(username, password, name, accountStatus);
	}
}
