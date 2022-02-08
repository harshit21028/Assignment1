package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment1.controller.CovidCheck;
import com.example.assignment1.controller.CovidCheck_Interface;
import com.example.assignment1.controller.DisplaySymptoms;
import com.example.assignment1.controller.DisplaySymptoms_Interface;
import com.example.assignment1.model.User;
import com.example.assignment1.view.Display_Interface;
import com.example.assignment1.view.Main_View_Interface;

public class DisplayActivity extends AppCompatActivity implements Display_Interface {

    TextView userSymptoms;
    Button checkBtn;
    User user;
    public DisplaySymptoms_Interface controller;
    String activityName = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String message = "State of activity " + activityName + " is Created";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        userSymptoms = (TextView) findViewById(R.id.userSymptoms);
        checkBtn = (Button) findViewById(R.id.checkBtn);

        Intent intent = getIntent();
        Object user_object = intent.getSerializableExtra("usr");
        user = (User) user_object;

        controller = new DisplaySymptoms((Display_Interface) this);
        controller.processResponses(user);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.countPositiveSymptoms(user);
            }
        });

    }

    @Override
    public void displayUserResponses(String txt) {
        userSymptoms.setText(txt);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String message = "State of activity " + activityName + " changed from Created to Started";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String message = "State of activity " + activityName + " changed from Stopped to Started";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String message = "State of activity " + activityName + " changed from Paused to Resumed";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String message = "State of activity " + activityName + " changed from Running to Paused";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        String message = "State of activity " + activityName + " changed from Paused to Stopped";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String message = "State of activity " + activityName + " changed from Stopped to Destroyed";
        Log.i(activityName, message);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}