package com.appgate.refactoring.exercise.services.tweeter;

import com.appgate.refactoring.exercise.model.entities.TweeterEntity;

public interface DatabaseTweeterService {
	void createTweet(TweeterEntity entity);
}
