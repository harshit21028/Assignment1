package com.example.assignment1.controller;

import com.example.assignment1.model.User;
import com.example.assignment1.view.Main_View_Interface;

public class CovidCheck implements CovidCheck_Interface{

    Main_View_Interface mainView;
    User user = null;

    public CovidCheck(Main_View_Interface mainView) {
        this.mainView = mainView;
        user = new User();
    }


    @Override
    public void nextBtnClick(String responseTxt, int total) {
        int i;
        String[] symptoms = user.get_symptoms();
        String[] responses = user.get_responses();
        int length = symptoms.length;
        if(total < (length-1)) {
            responses[total] = responseTxt;
            mainView.updateSymptom(symptoms[++total]);
        }else{
            responses[total] = responseTxt;
            mainView.updateSymptom("");
        }
    }

    @Override
    public void clearBtnClick() {
        user = new User();
        mainView.clearForm(user.get_symptoms()[0]);
    }

    @Override
    public void submitBtnClick() {
        mainView.submitForm(user);
    }
}
