package com.example.amosh.educationalapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup Q2 = (RadioGroup) findViewById(R.id.Question2);
        RadioGroup Q4 = (RadioGroup) findViewById(R.id.Question4);

        // Clearing Radio Group Selection

        int selectedid = Q2.getCheckedRadioButtonId();
        if (selectedid > 0) {
            Q2.clearCheck();
        }
        int selectedId = Q4.getCheckedRadioButtonId();
        if (selectedid > 0) {
            Q4.clearCheck();
        }

    }


    public void submitAnswer(View view) {

        // Getting Question 1 Of type Text Answer
        EditText Answer_1 = (EditText) findViewById(R.id.Answer_1);
        String Answer1 = Answer_1.getText().toString().trim();
        if (Answer1.matches("")) {
            Toast.makeText(this, getString(R.string.Erorr1), Toast.LENGTH_SHORT).show();
            return;
        }
        if (Answer1.matches("Asia")) {
            score = score + 1;
        }


        // Getting Question 2 Of type RadioGruop Answer
        RadioGroup Q2 = (RadioGroup) findViewById(R.id.Question2);
        Q2.getCheckedRadioButtonId();
        if (Q2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, getString(R.string.Erorr2), Toast.LENGTH_SHORT).show();
            return;
        }
        int Q2Answer = Q2.indexOfChild(findViewById(Q2.getCheckedRadioButtonId()));
        if (Q2Answer == 2) {
            score = score + 1;
        }

        // Getting Question 3 Of type CheckBox Answer
        CheckBox Asia = (CheckBox) findViewById(R.id.Answer3_1);
        boolean Answer3_1 = Asia.isChecked();

        CheckBox Africa = (CheckBox) findViewById(R.id.Answer3_2);
        boolean Answer3_2 = Africa.isChecked();


        CheckBox Europe = (CheckBox) findViewById(R.id.Answer3_3);
        boolean Answer3_3 = Europe.isChecked();

        if (Answer3_1 == false && Answer3_2 == false && Answer3_3 == false) {
            Toast.makeText(this, getString(R.string.Erorr3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (Answer3_1 == true && Answer3_3 == true && Answer3_2 == false) {
            score = score + 1;

        }

        // Getting Question 4 of type RadioGroup Answer
        RadioGroup Q4 = (RadioGroup) findViewById(R.id.Question4);
        Q4.getCheckedRadioButtonId();
        if (Q4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, getString(R.string.Erorr4), Toast.LENGTH_SHORT).show();
            return;
        }
        int Q4Answer = Q4.indexOfChild(findViewById(Q2.getCheckedRadioButtonId()));
        if (Q4Answer == -1) {
            score = score + 1;
        }


        // Getting Question 1 Of type Text Answer
        EditText Answer_5 = (EditText) findViewById(R.id.Answer_5);
        String Answer5 = Answer_5.getText().toString().trim();
        if (Answer5.matches("")) {
            Toast.makeText(this, getString(R.string.Erorr5), Toast.LENGTH_SHORT).show();
            return;
        }
        if (Answer5.matches("Australia")) {
            score = score + 1;
        }

        // Result Methode
        result(score);


    }

    private void result(int sc) {
        // Full Degree :)
        if (sc == 5) {
            Toast.makeText(this, R.string.All_True, Toast.LENGTH_SHORT).show();

            // Non Full Degree :(
        } else {
            Toast.makeText(this, R.string.All_False, Toast.LENGTH_SHORT).show();

        }
        score = 0;
    }


}