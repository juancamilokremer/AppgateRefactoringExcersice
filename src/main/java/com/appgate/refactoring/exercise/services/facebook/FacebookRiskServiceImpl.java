package com.appgate.refactoring.exercise.services.facebook;

import org.springframework.stereotype.Service;

import com.appgate.refactoring.exercise.services.RiskService;
import com.appgate.refactoring.exercise.services.enumerations.Risks;

@Service
public class FacebookRiskServiceImpl implements RiskService {

	@Override
	public Risks calculate(double score) {
		Risks risk = null;
		
		if (score == -100d) {
			return Risks.HIGH_RISK;
		} else if (score > -100d && score < 50d) {
			return Risks.MEDIUM_RISK;
		} else if (score >= 50d) {
			return Risks.LOW_RISK;
		}
		
		return risk;
	}

}
