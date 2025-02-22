package com.appgate.refactoring.exercise.services.facebook;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.model.entities.FacebookEntity;
import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;
import com.appgate.refactoring.exercise.utilities.FacebookAnalyzer;

@Service
public class FacebookServiceImpl implements FacebookService {
	private DatabaseFacebookService databaseService;
	private RiskService riskService;
	
	public FacebookServiceImpl(DatabaseFacebookService databaseService, FacebookRiskServiceImpl riskService) {
		this.databaseService = databaseService;
		this.riskService = riskService;
	}
	
	@Override
	public String analyze(String account, String message, List<String> comments) {
		double score = 0;

		String comment = concatComments(comments);
		
		String formatedMessage = formatMessage(message, comment);

		score = scoreComments(formatedMessage);

		// Analyze facebook post (if facebook is already low then skip this analysis)
		if (score > -100) {
			score = FacebookAnalyzer.analyzePost(formatedMessage, account);
			FacebookEntity entity = new FacebookEntity(score, formatedMessage, account);
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
		return new StringBuffer("facebookMessage: ")
				.append(message)
				.append(" || comments: ")
				.append(comment)
				.toString();
	}
	
	private double scoreComments(String message) {
		double facebookScore = 0;
		
		if (message.contains("comments:")) {
			double facebookCommentsScore = FacebookAnalyzer.calculateFacebookCommentsScore(
					message.substring(message.indexOf("comments:")));
	
			if (facebookCommentsScore < 50d) {
				facebookScore = Double.sum(facebookScore, -100d);
			}
		}
		return facebookScore;
	}
}
