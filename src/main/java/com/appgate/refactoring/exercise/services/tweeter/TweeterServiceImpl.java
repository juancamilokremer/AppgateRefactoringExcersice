package com.appgate.refactoring.exercise.services.tweeter;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.entities.TweeterEntity;
import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;
import com.appgate.refactoring.exercise.utilities.TweeterAnalyzer;

@Service
public class TweeterServiceImpl implements TweeterService {	
	private DatabaseTweeterService databaseService;
	private RiskService riskService;
	
	public TweeterServiceImpl(DatabaseTweeterService databaseService, TweeterRiskServiceImpl riskService) {
		this.databaseService = databaseService;
		this.riskService = riskService;
	}
	
	@Override
	public String analyze(String message, String url, String account) {
		String formatedMessage = "tweeterMessage: " + message;
		double tweeterScore = TweeterAnalyzer.analyzeTweet(formatedMessage, url, account);
		createTweet(tweeterScore, formatedMessage, url, account);
		Risks risk = riskService.calculate(tweeterScore);
		
		if(risk != null) {
			return risk.name();			
		} else {
			return formatedMessage;
		}
	}
	
	private void createTweet(double score, String message, String url, String account) {
		TweeterEntity entity = new TweeterEntity(score, message, url, account);
		databaseService.createTweet(entity);
	}
}
