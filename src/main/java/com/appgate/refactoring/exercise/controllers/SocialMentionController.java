package com.appgate.refactoring.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.refactoring.exercise.model.SocialMention;
import com.appgate.refactoring.exercise.services.SocialMentionFactory;
import com.appgate.refactoring.exercise.services.SocialMentionService;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;

@RestController
@RequestMapping("api/social_mention")
public class SocialMentionController {
	@Autowired
	SocialMentionFactory socialMentionFactory;
	
	@PostMapping(value = "/analyze", produces = MediaType.TEXT_PLAIN_VALUE)
	public String analyze(@RequestBody SocialMention socialMention) {
		SocialMentionService service = SocialMentionFactory.getSocialMentionService(SocialTypes.valueOf(socialMention.getType()));
		
		return service.analyze(socialMention);
	}
}
