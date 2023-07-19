package com.masai.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Status;

@Embeddable
public class Lecture {
	@Column(nullable = false, unique = true)
	private long lectureId;
	private String title;
	private String details;
	@Enumerated(EnumType.STRING)
	private Status isWatched;
	private LocalDate uplodedAt;
	private String url;
	@Enumerated(EnumType.STRING)
	private State is_deleted;
	
	
	public Lecture() {
		super();
	}


	public Lecture(long lectureId, String title, String details, Status isWatched, LocalDate uplodedAt, String url,
			State is_deleted) {
		super();
		this.lectureId = lectureId;
		this.title = title;
		this.details = details;
		this.isWatched = isWatched;
		this.uplodedAt = uplodedAt;
		this.url = url;
		this.is_deleted = is_deleted;
	}


	public long getLectureId() {
		return lectureId;
	}


	public void setLectureId(long lectureId) {
		this.lectureId = lectureId;
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


	public Status getIsWatched() {
		return isWatched;
	}


	public void setIsWatched(Status isWatched) {
		this.isWatched = isWatched;
	}


	public LocalDate getUplodedAt() {
		return uplodedAt;
	}


	public void setUplodedAt(LocalDate uplodedAt) {
		this.uplodedAt = uplodedAt;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public State getIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(State is_deleted) {
		this.is_deleted = is_deleted;
	}


	@Override
	public String toString() {
		return "Lecture [lectureId=" + lectureId + ", title=" + title + ", details=" + details + ", isWatched="
				+ isWatched + ", uplodedAt=" + uplodedAt + ", url=" + url + ", is_deleted=" + is_deleted + "]";
	}
}
