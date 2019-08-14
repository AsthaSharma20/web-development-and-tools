/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.abstractwizrd.controller;


import com.neu.abstractwizrd.pojo.QuestionOption;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 *
 * @author kasai
 */
public class QuizController extends AbstractWizardFormController {

    public QuizController() {
        setCommandName("quizForm");
        setCommandClass(QuestionOption.class);
        setPages(new String[]{"pageone", "pagetwo", "pagethree", "result"});

    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

     
        QuestionOption questionOption = new QuestionOption();
        
        Map<String,Integer> correctOption = new LinkedHashMap<>();
        
        correctOption.put("Question1", 3);
        correctOption.put("Question2", 1);
        correctOption.put("Question3", 4);
        
        questionOption.setCorrectOption(correctOption);
        
        return questionOption;
        
        
    }

    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {

        // Read command object
        QuestionOption question = (QuestionOption) command;
        
        Map<String,Integer> userChoice = question.getUserOption();
        
        Map<String,Integer> correctChoice = question.getCorrectOption();
         
        int score = 0;
        for (Map.Entry<String, Integer> entry1 : correctChoice.entrySet()) {
            String key = entry1.getKey();
            Integer value1 = entry1.getValue();
            Integer value2 = userChoice.get(key); 
            
            if(value1.equals(value2)){
                score++;
            }
          }
        
        return new ModelAndView("result", "score", score);
    }
    
    
    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {

        // If user click on cancel
        return new ModelAndView("cancel");
    }
    
    @Override
    protected void validatePage(Object command, Errors errors, int page) {

        QuizValidator quizValidator = (QuizValidator) getValidator();
       
        switch (page) {
        case 0: // if page is 1 then validate it
            quizValidator.validatePage1(command, errors);
            break;
        case 1: // if page is 2 then validate it
            quizValidator.validatePage2(command, errors);
            break;
        case 2: // if page is 3 then validate it
            quizValidator.validatePage3(command, errors);
            break;
        }

    }

}
