/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.abstractwizrd.pojo;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class QuestionOption {
    
    
    private Map<String,Integer> userOption;
    
    private Map<String,Integer> correctOption;
    
    
    public QuestionOption() {
        
        userOption = new LinkedHashMap<>();
        
    }

    public Map<String, Integer> getUserOption() {
        return userOption;
    }

    public void setUserOption(Map<String, Integer> userOption) {
            this.userOption = userOption;
        
    }

    public Map<String, Integer> getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(Map<String, Integer> correctOption) {
        this.correctOption = correctOption;
    }

    @Override
    public String toString() {
        return "QuestionOption{" + "userOption=" + userOption + ", correctOption=" + correctOption + '}';
    }

    

    
   

    
    
    
    
}
