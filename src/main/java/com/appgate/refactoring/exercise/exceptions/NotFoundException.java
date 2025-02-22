package com.appgate.refactoring.exercise.exceptions;

public class NotFoundException extends RuntimeException {
	private static final String DESCRIPTION = "Bad Request Exception (400)";

	public NotFoundException(String message) {
		super(DESCRIPTION + " . " + message);
	}
}
