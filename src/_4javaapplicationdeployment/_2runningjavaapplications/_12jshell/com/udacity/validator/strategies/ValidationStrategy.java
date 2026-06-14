package _4javaapplicationdeployment._2runningjavaapplications._12jshell.com.udacity.validator.strategies;

import com.udacity.domain.User;

@FunctionalInterface
public interface ValidationStrategy {
	boolean validateUser(User user);
}
