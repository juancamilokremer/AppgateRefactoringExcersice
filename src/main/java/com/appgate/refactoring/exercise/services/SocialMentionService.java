package com.appgate.refactoring.exercise.services;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.SocialMentionBuilder;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;

@Service
public interface SocialMentionService {
	public final String FACEBOOK_TYPE = "facebook";
	public final String TWEETER_TYPE = "tweeter";
	
	SocialTypes getType();
	
	String analyze(SocialMentionBuilder builder);
}
