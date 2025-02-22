package com.appgate.refactoring.exercise.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "analyzed_tweets")
public class TweeterEntity {
	@Id
	private Long id;
	private double score;
	private String message;
	private String url;
	private String account;
	
	public TweeterEntity() {
		super();
	}

	public TweeterEntity(double score, String message, String url, String account) {
		super();
		this.score = score;
		this.message = message;
		this.url = url;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
