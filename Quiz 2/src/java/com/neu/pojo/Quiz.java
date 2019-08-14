/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asthasharma
 */
public class Quiz {
    
    private String question;
    private List<String> option=new ArrayList<String>();
    

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

  
    
    
    
}
