package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(name = "account_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private State accountStatus;

	public User() {
		super();
	}

	public User(String username, String password, String name, State accountStatus) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.accountStatus = accountStatus;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(State accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + "]";
	}

}
