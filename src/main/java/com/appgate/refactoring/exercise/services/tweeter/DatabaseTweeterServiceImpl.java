package com.appgate.refactoring.exercise.services.tweeter;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.entities.TweeterEntity;
import com.appgate.refactoring.exercise.repositories.TweeterRepository;

@Service
public class DatabaseTweeterServiceImpl implements DatabaseTweeterService {

	TweeterRepository repository;
	
	public DatabaseTweeterServiceImpl(TweeterRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void createTweet(TweeterEntity entity) {
		repository.save(entity);
	}

}
