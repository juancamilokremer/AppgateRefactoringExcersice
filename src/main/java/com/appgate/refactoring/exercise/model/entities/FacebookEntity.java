package com.appgate.refactoring.exercise.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "analyzed_fb_posts")
public class FacebookEntity {

	@Id
	private Long Id;
	private double score;
	private String message;
	private String account;

	public FacebookEntity() {
		super();
	}

	public FacebookEntity(double score, String message, String account) {
		super();
		this.score = score;
		this.message = message;
		this.account = account;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
