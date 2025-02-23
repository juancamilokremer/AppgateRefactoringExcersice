package com.appgate.refactoring.exercise.services;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.exceptions.NotFoundException;
import com.appgate.refactoring.exercise.model.SocialMention;
import com.appgate.refactoring.exercise.model.SocialMentionBuilder;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;

@Service
public class SocialMentionBuilderFactory {
		
	public SocialMentionBuilder getSocialMentionBuilder(SocialMention socialMention) {
		SocialMentionBuilder socialMentionBuilder;
		
		if(socialMention == null || socialMention.getType() == null) {
			throw new NotFoundException("Unknown service type: " + socialMention.getType());
		}
		
        if (SocialTypes.FACEBOOK.name().equals(socialMention.getType())) {
        	socialMentionBuilder = new SocialMentionBuilder()
				.setFacebookAccount(socialMention.getFacebookAccount())
				.setMessage(socialMention.getMessage())
				.setFacebookComments(socialMention.getFacebookComments())
				.build();
        } else if(SocialTypes.TWEETER.name().equals(socialMention.getType())) {
        	socialMentionBuilder= new SocialMentionBuilder()
				.setMessage(socialMention.getMessage())
				.setTweeterUrl(socialMention.getTweeterUrl())
				.setTweeterAccount(socialMention.getTweeterAccount())
				.build();
        } else {
        	throw new NotFoundException("Unknown service type: " + socialMention.getType());
        }
        
        return socialMentionBuilder;
    }
}
