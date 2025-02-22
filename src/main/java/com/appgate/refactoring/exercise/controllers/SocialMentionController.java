package com.appgate.refactoring.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.refactoring.exercise.exceptions.NotFoundException;
import com.appgate.refactoring.exercise.model.SocialMention;
import com.appgate.refactoring.exercise.services.facebook.FacebookService;
import com.appgate.refactoring.exercise.services.tweeter.TweeterService;

@RestController
@RequestMapping("api/social_mention")
public class SocialMentionController {
	@Autowired
	private FacebookService facebookservice;
	@Autowired
	private TweeterService tweeterService;

	@PostMapping(value = "/analyze", produces = MediaType.TEXT_PLAIN_VALUE)
	public String analyze(@RequestBody SocialMention socialMention) {
		String message;

		if (socialMention.getFacebookAccount() != null) {
			message = facebookservice.analyze(
					socialMention.getFacebookAccount(), 
					socialMention.getMessage(),
					socialMention.getFacebookComments());
		} else if (socialMention.getTweeterAccount() != null) {
			message = tweeterService.analyze(
					socialMention.getMessage(), 
					socialMention.getTweeterUrl(), 
					socialMention.getTweeterAccount());
		} else {
			throw new NotFoundException("Error, Tweeter or Facebook account must be present");
		}

		return message;
	}
}
