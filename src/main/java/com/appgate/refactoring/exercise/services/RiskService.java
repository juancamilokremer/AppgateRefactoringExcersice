package com.appgate.refactoring.exercise.services;

import com.appgate.refactoring.exercise.services.enumerations.Risks;

public interface RiskService {
	
	Risks calculate(double score);
}
