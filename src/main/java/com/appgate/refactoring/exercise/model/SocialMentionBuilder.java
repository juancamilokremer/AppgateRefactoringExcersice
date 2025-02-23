package com.appgate.refactoring.exercise.model;

import java.util.List;

public class SocialMentionBuilder {
	private String message;
	private String facebookAccount;
	private String tweeterAccount;
	private String creationDate;
	private String tweeterUrl;
	private List<String> facebookComments;

	public SocialMentionBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public SocialMentionBuilder setFacebookAccount(String facebookAccount) {
		this.facebookAccount = facebookAccount;
		return this;
	}

	public SocialMentionBuilder setTweeterAccount(String tweeterAccount) {
		this.tweeterAccount = tweeterAccount;
		return this;
	}

	public SocialMentionBuilder setCreationDate(String creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public SocialMentionBuilder setTweeterUrl(String tweeterUrl) {
		this.tweeterUrl = tweeterUrl;
		return this;
	}

	public SocialMentionBuilder setFacebookComments(List<String> facebookComments) {
		this.facebookComments = facebookComments;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public String getFacebookAccount() {
		return facebookAccount;
	}

	public String getTweeterAccount() {
		return tweeterAccount;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getTweeterUrl() {
		return tweeterUrl;
	}

	public List<String> getFacebookComments() {
		return facebookComments;
	}

	public SocialMentionBuilder build() {
		SocialMentionBuilder socialMention = new SocialMentionBuilder();
		socialMention.setMessage(this.message);
		socialMention.setFacebookAccount(this.facebookAccount);
		socialMention.setTweeterAccount(this.tweeterAccount);
		socialMention.setCreationDate(this.creationDate);
		socialMention.setTweeterUrl(this.tweeterUrl);
		socialMention.setFacebookComments(this.facebookComments);
		
		return socialMention;
	}
}
