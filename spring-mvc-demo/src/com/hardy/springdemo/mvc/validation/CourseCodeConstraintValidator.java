package com.hardy.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	public String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {

		coursePrefix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result = false;
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}
		return result;
	}

}
