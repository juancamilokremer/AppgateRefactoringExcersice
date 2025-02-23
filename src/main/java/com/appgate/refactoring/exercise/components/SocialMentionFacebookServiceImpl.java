package com.appgate.refactoring.exercise.components;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appgate.refactoring.exercise.exceptions.NotFoundException;
import com.appgate.refactoring.exercise.model.SocialMention;
import com.appgate.refactoring.exercise.model.entities.FacebookEntity;
import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.SocialMentionService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;
import com.appgate.refactoring.exercise.services.enumerations.SocialTypes;
import com.appgate.refactoring.exercise.services.facebook.DatabaseFacebookService;
import com.appgate.refactoring.exercise.services.facebook.FacebookRiskServiceImpl;
import com.appgate.refactoring.exercise.utilities.FacebookAnalyzer;

@Component
public class SocialMentionFacebookServiceImpl implements SocialMentionService {
	private DatabaseFacebookService databaseService;
	private RiskService riskService;

	public SocialMentionFacebookServiceImpl(DatabaseFacebookService databaseService,
			FacebookRiskServiceImpl riskService) {
		this.databaseService = databaseService;
		this.riskService = riskService;
	}

	@Override
	public String analyze(SocialMention socialMention) {
		if(socialMention.getFacebookAccount() == null) {
			throw new NotFoundException("Error, Facebook account must be present");
		}

		String comment = concatComments(socialMention.getFacebookComments());

		String formatedMessage = formatMessage(socialMention.getMessage(), comment);

		double score = scoreComments(formatedMessage);

		if (score > -100) {
			score = FacebookAnalyzer.analyzePost(formatedMessage, socialMention.getFacebookAccount());
			FacebookEntity entity = new FacebookEntity(score, formatedMessage, socialMention.getFacebookAccount());
			databaseService.createPost(entity);
		}

		Risks risk = riskService.calculate(score);

		if (risk != null) {
			return risk.name();
		} else {
			return formatedMessage;
		}
	}

	private String concatComments(List<String> comments) {
		return comments.stream().reduce("", (h, c) -> h + " " + c);
	}

	private String formatMessage(String message, String comment) {
		return new StringBuffer("facebookMessage: ").append(message).append(" || comments: ").append(comment)
				.toString();
	}

	private double scoreComments(String message) {
		double facebookScore = 0;

		if (message.contains("comments:")) {
			double facebookCommentsScore = FacebookAnalyzer
					.calculateFacebookCommentsScore(message.substring(message.indexOf("comments:")));

			if (facebookCommentsScore < 50d) {
				facebookScore = Double.sum(facebookScore, -100d);
			}
		}
		return facebookScore;
	}

	@Override
	public SocialTypes getType() {
		return SocialTypes.FACEBOOK;
	}
}
