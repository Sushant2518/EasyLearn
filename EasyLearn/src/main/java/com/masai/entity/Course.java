package com.masai.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseID;
	private String courseName;
	
	
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
	@ElementCollection(fetch=FetchType.EAGER)
	@Embedded
	private Set<Assignment> assignments = new HashSet<>();
	@ElementCollection(fetch=FetchType.EAGER)
	@Embedded
	private Set<Quiz> quizzes = new HashSet<>();
	@ElementCollection(fetch=FetchType.EAGER)
	@Embedded
	private Set<Lecture> lectures = new HashSet<>();
	
	
	
	@Enumerated(EnumType.STRING)
	private State courseStatus;
	
	
	public Course() {
		super();
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public State getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(State courseStatus) {
		this.courseStatus = courseStatus;
	}

	// getter setters for quiz

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignments, courseID, courseName, courseStatus, lectures, quizzes, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(assignments, other.assignments) && courseID == other.courseID
				&& Objects.equals(courseName, other.courseName) && courseStatus == other.courseStatus
				&& Objects.equals(lectures, other.lectures) && Objects.equals(quizzes, other.quizzes)
				&& Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
	}
	
}
