package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Student extends User {
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Course> courses = new HashSet<>();

	public Student() {
		super();
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student(String username, String password, String name, State accountStatus) {
		super(username, password, name, accountStatus);
	}

	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getName()=" + getName() + "]";
	}
}
