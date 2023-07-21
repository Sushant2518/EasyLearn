package com.masai.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Quiz {
	@Column(nullable = false, unique = true)
	private long quizId;
	private String title;
	private String details;
	@Enumerated(EnumType.STRING)
	private Status isCompleted;
	private LocalDate givenAt;
	private LocalDate endAt;
	@Enumerated(EnumType.STRING)
	private State is_deleted;
	
	public Quiz(long quizId, String title, String details, Status isCompleted, LocalDate givenAt, LocalDate endAt,
			State is_deleted) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.details = details;
		this.isCompleted = isCompleted;
		this.givenAt = givenAt;
		this.endAt = endAt;
		this.is_deleted = is_deleted;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
	public String toString() {
		return "Quiz [Quiz Id : " + quizId + ", title=" + title + ", details=" + details + ", status : " + isCompleted
				+ ", givenAt=" + givenAt + ", endAt=" + endAt + "]";
	}
	
}
