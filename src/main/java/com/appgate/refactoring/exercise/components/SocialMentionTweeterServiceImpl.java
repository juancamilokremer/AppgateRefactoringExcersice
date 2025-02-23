package com.appgate.refactoring.exercise.components;

import org.springframework.stereotype.Component;

import com.appgate.refactoring.exercise.model.SocialMentionBuilder;
import com.appgate.refactoring.exercise.model.entities.TweeterEntity;
import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.SocialMentionService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;
import com.appgate.refactoring.exercise.services.tweeter.DatabaseTweeterService;
import com.appgate.refactoring.exercise.services.tweeter.TweeterRiskServiceImpl;
import com.appgate.refactoring.exercise.utilities.TweeterAnalyzer;

@Component
public class SocialMentionTweeterServiceImpl implements SocialMentionService {
	private DatabaseTweeterService databaseService;
	private RiskService riskService;

	public SocialMentionTweeterServiceImpl(DatabaseTweeterService databaseService, TweeterRiskServiceImpl riskService) {
		this.databaseService = databaseService;
		this.riskService = riskService;
	}

	@Override
	public String analyze(SocialMentionBuilder builder) {
		String formatedMessage = "tweeterMessage: " + builder.getMessage();
		double tweeterScore = TweeterAnalyzer.analyzeTweet(formatedMessage, builder.getTweeterUrl(),
				builder.getTweeterAccount());
		createTweet(tweeterScore, formatedMessage, builder.getTweeterUrl(), builder.getTweeterAccount());
		Risks risk = riskService.calculate(tweeterScore);

		if (risk != null) {
			return risk.name();
		} else {
			return formatedMessage;
		}
	}

	private void createTweet(double score, String message, String url, String account) {
		TweeterEntity entity = new TweeterEntity(score, message, url, account);
		databaseService.createTweet(entity);
	}

	@Override
	public SocialTypes getType() {
		return SocialTypes.TWEETER;
	}
}
