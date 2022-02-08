package com.example.assignment1.model;

import java.io.Serializable;
import java.util.Arrays;

public class User implements User_Interface, Serializable {

    String symptoms[];
    String responses[];

    public User(){
        this.symptoms = new String[]{"Fever", "Runny Nose", "Scratchy Throat", "Body Ache", "Headache"};
        this.responses = new String[]{"","","","",""};
    }

    public User(String[] symptoms, String[] responses) {
        this.symptoms = symptoms;
        this.responses = responses;
    }

    @Override
    public String[] get_symptoms() {
        return symptoms;
    }

    @Override
    public String[] get_responses() {
        return responses;
    }

    @Override
    public void set_symptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public void set_responses(String[] responses) {
        this.responses = responses;
    }

    @Override
    public int check_symptoms() {
        int i,s;
        s=0;
        for(i=0;i< responses.length;i++){
            if(responses[i].equals("Yes"))
                s = s + 1;
        }
        return s;
    }

    @Override
    public String toString() {
        int i;
        String user = "";
        for(i = 0 ; i <symptoms.length; i++){
            user = user + symptoms[i] + "\t:\t" + responses[i] + "\n\n";
        }
        return user;
    }
}
