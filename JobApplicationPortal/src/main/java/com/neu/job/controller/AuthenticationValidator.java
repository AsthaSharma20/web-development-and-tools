package com.neu.job.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.job.pojo.User;

public class AuthenticationValidator {
		public boolean supports(Class clazz) {
			// TODO Auto-generated method stub
			
			return clazz.equals(User.class);
		}

		public void validate(Object target, Errors errors) {
			// TODO Auto-generated method stub
			
			User c=(User) target;
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "error.invalid.role", "Role  required");
			
			if(errors.hasErrors()){
		           return;
		       }
			
		}

	}


