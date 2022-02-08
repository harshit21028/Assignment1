package com.example.assignment1.controller;

import com.example.assignment1.model.User;
import com.example.assignment1.view.Display_Interface;

public class DisplaySymptoms implements DisplaySymptoms_Interface{

    Display_Interface displayView;

    public DisplaySymptoms(Display_Interface view){
        this.displayView = view;
    }

    @Override
    public void processResponses(User user) {
        String txt;
        txt = user.toString();
        displayView.displayUserResponses(txt);
    }

    @Override
    public void countPositiveSymptoms(User user) {
        int positive = user.check_symptoms();
        System.out.println("Positive:" + positive);
        if(positive > 3){
            displayView.showToast("Please get Tested as soon as possible!!");
        }else{
            displayView.showToast("No need to get Tested.");
        }
    }
}
