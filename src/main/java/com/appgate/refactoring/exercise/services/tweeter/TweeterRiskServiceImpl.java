package com.appgate.refactoring.exercise.services.tweeter;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;

@Service
public class TweeterRiskServiceImpl implements RiskService{

	@Override
	public Risks calculate(double score) {
		Risks risk = null;
		
		if (score >= -1 && score <= -0.5d) {
			risk = Risks.HIGH_RISK;
		} else if (score > -0.5d && score < 0.7d) {
			risk = Risks.MEDIUM_RISK;
		} else if (score >= 0.7d) {
			risk = Risks.LOW_RISK;
		}
		
		return risk;
	}

}
