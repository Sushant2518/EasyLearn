package com.masai.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Status;

@Embeddable
public class Assignment {
	@Column(nullable = false, unique = true)
	private long assignmentID;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status isCompleted;
	private LocalDate givenAt;
	private LocalDate endAt;
	@Enumerated(EnumType.STRING)
	private State is_deleted;
	
	
	
	
	public Assignment() {
		super();
	}

	public Assignment(long assignmentID, String title, String description, Status isCompleted, LocalDate givenAt,
			LocalDate endAt, State is_deleted) {
		super();
		this.assignmentID = assignmentID;
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
		this.givenAt = givenAt;
		this.endAt = endAt;
		this.is_deleted = is_deleted;
	}

	public long getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(long assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Status isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDate getGivenAt() {
		return givenAt;
	}

	public void setGivenAt(LocalDate givenAt) {
		this.givenAt = givenAt;
	}

	public LocalDate getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDate endAt) {
		this.endAt = endAt;
	}

	public State getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(State is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignmentID, description, endAt, givenAt, isCompleted, is_deleted, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		return assignmentID == other.assignmentID && Objects.equals(description, other.description)
				&& Objects.equals(endAt, other.endAt) && Objects.equals(givenAt, other.givenAt)
				&& Objects.equals(isCompleted, other.isCompleted) && is_deleted == other.is_deleted
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Assignment [assignmentID=" + assignmentID + ", title=" + title + ", description=" + description
				+ ", isCompleted=" + isCompleted + ", givenAt=" + givenAt + ", endAt=" + endAt + ", is_deleted="
				+ is_deleted + "]";
	}
	
	
	
}
