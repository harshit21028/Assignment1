package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment1.controller.CovidCheck;
import com.example.assignment1.controller.CovidCheck_Interface;
import com.example.assignment1.model.User;
import com.example.assignment1.view.Main_View_Interface;

public class MainActivity extends AppCompatActivity implements Main_View_Interface {

    public EditText txtName;
    public TextView symptom_txtView;
    public Button nextBtn, clearBtn, submitBtn;
    public RadioGroup yes_no;
    public RadioButton resBtn;
    public CovidCheck_Interface controller;
    int total = 0, flag = 0;
    String next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.editTextName);
        symptom_txtView = (TextView) findViewById(R.id.symptom_txtview);
        nextBtn = (Button) findViewById(R.id.next_btn);
        clearBtn = (Button) findViewById(R.id.clear_button);
        submitBtn = (Button) findViewById(R.id.submit_button);

        yes_no = (RadioGroup) findViewById(R.id.optionGroup);

        controller = new CovidCheck((Main_View_Interface) this);

        controller.clearBtnClick();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int response = yes_no.getCheckedRadioButtonId();
                System.out.println(response);
                resBtn = (RadioButton) findViewById(response);
                if (response == (-1)) {
                    Toast.makeText(getApplicationContext(), "Please select atleast one option", Toast.LENGTH_LONG).show();
                } else {
                    controller.nextBtnClick(resBtn.getText().toString(), total);
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.clearBtnClick();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.submitBtnClick();
            }
        });

    }


    @Override
    public void updateSymptom(String symptom) {
        if (!(symptom.equals(""))) {
            symptom_txtView.setText(symptom);
            yes_no.clearCheck();
            total++;
        } else {
            flag = 1;
            nextBtn.setEnabled(false);
        }
    }

    @Override
    public void clearForm(String firstSymptom) {
        total = 0;
        flag = 0;
        symptom_txtView.setText(firstSymptom);
        nextBtn.setEnabled(true);
    }

    @Override
    public void submitForm(User user) {
        if (flag == 1) {
            Intent intent;
            intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("usr", user);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Please mark for all symptoms", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main Activity:", "Started");
        Toast.makeText(getApplicationContext(), "Main Activity Started", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Main Activity:", "Restarted");
        Toast.makeText(getApplicationContext(), "Main Activity Restarted", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main Activity:", "Resumed");
        Toast.makeText(getApplicationContext(), "Main Activity Resumed", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main Activity:", "Paused");
        Toast.makeText(getApplicationContext(), "Main Activity Paused", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main Activity:", "Stopped");
        Toast.makeText(getApplicationContext(), "Main Activity Stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main Activity:", "Destroyed");
        Toast.makeText(getApplicationContext(), "Main Activity Destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Main Activity:", "Configuration Changed");
        Toast.makeText(getApplicationContext(), "Main Activity Configuration Changed", Toast.LENGTH_LONG).show();
    }
}
