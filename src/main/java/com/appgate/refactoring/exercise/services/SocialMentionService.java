package com.appgate.refactoring.exercise.services;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.SocialMention;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;

@Service
public interface SocialMentionService {	
	SocialTypes getType();
	
	String analyze(SocialMention socialMention);
}
