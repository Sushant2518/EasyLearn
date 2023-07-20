package com.masai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseID;
	private String courseName;
	
	@Enumerated(EnumType.STRING)
	private State courseStatus;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public int getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseStatus(State courseStatus) {
		this.courseStatus = courseStatus;
	}

	public State getCourseStatus() {
		return courseStatus;
	}
	
	
	
}
