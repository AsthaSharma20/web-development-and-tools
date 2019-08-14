/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.abstractwizrd.controller;


import com.neu.abstractwizrd.pojo.QuestionOption;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author kasai
 */
public class QuizValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        
        return QuestionOption.class.isAssignableFrom(clazz);
        
    }

    @Override
    public void validate(Object o, Errors errors) {
        
    }
    
    public void validatePage1(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userOption['Question1']", "required.userAns", "Please select one of the Answers.");
        
    }
    
    public void validatePage2(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userOption['Question2']", "required.userAns", "Please select one of the Answers.");
        
    }
    
     public void validatePage3(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userOption['Question3']", "required.userAns", "Please select one of the Answers.");
        
    }
    
}
