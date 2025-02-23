package com.appgate.refactoring.exercise.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.exceptions.NotFoundException;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;

import jakarta.annotation.PostConstruct;

@Service
public class SocialMentionFactory {
	@Autowired
    private List<SocialMentionService> services;
	
	private static final Map<SocialTypes, SocialMentionService> serviceCache = new HashMap<>();
	
	@PostConstruct
    public void initServiceCache() {
        for(SocialMentionService service : services) {
            serviceCache.put(service.getType(), service);
        }
    }
	
	public static SocialMentionService getSocialMentionService(SocialTypes type) {
		SocialMentionService service = serviceCache.get(type);
		
        if(service == null) {
        	throw new NotFoundException("Unknown service type: " + type);
        }
        
        return service;
    }
}
