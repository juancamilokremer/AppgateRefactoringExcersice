package com.appgate.refactoring.exercise.services.facebook;

import java.util.List;

public interface FacebookService {

	String analyze(String account, String message, List<String> comments);
}
