package com.appgate.refactoring.exercise.services.facebook;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.entities.FacebookEntity;
import com.appgate.refactoring.exercise.repositories.FacebookRepository;

@Service
public class DatabaseFacebookServiceImpl implements DatabaseFacebookService {

	FacebookRepository repository;
	
	public DatabaseFacebookServiceImpl(FacebookRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createPost(FacebookEntity entity) {
		repository.save(entity);
	}

}
