package com.example.koala.radio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.koala.radio.R.id.Nineteenth;
import static com.example.koala.radio.R.id.radioGroup1;

public class MainActivity extends AppCompatActivity {


    //  Score now is 0, correct answers
    int score = 0;
    final int q1_answer = Nineteenth;
    final int q2_answer = R.id.Greek;
    final int q3_answer = R.id.Tree;
    //  q4 check box
    final String q5_answer = "Troy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//  Toast for Question 1
        final RadioButton nineteenth = (RadioButton) findViewById(Nineteenth);
        nineteenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nineteenth.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Yeah! 7 points for you!", Toast.LENGTH_LONG).show();
                }
            }
        });

//  Toast for Question 2
        final RadioButton greek = (RadioButton) findViewById(R.id.Greek);
        greek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greek.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Right! 5 points", Toast.LENGTH_LONG).show();
                }
            }
        });

//  Toast for Question 3
        final RadioButton tree = (RadioButton) findViewById(R.id.Tree);
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tree.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Very good! 10 points", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    //  How to calculate the score and the correct questions (if score is different from 0 the button 'check' doesn't work
//  otherwise doubles the value)
    public void checkQuiz(View view) {

        int numberOfQuestionsCorrect = 0;

        if (score != 0) {
            return;
        }

        if( checkQuestion1() ){
            numberOfQuestionsCorrect++;
            score = score + 7;
        }

        if( checkQuestion2() ){
            numberOfQuestionsCorrect++;
            score = score + 5;
        }

        if( checkQuestion3() ){
            numberOfQuestionsCorrect++;
            score = score + 10;
        }

        if( checkQuestion4() ){
            numberOfQuestionsCorrect++;
            score = score + 10;
        }

        if( checkQuestion5() ){
            numberOfQuestionsCorrect++;
            score = score + 5;
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/5 answers right";
        Toast.makeText(context, text, Toast.LENGTH_LONG ).show();

//  Display the score
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));
    }


    //  RadioGroup for Question 1, check if the answer is correct
    public boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(radioGroup1);

        if( rg.getCheckedRadioButtonId() == q1_answer ) {
            return true;
        }
        return false;
    }

    //  RadioGroup for Question 2, check if the answer is correct
    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup2);

        if( rg.getCheckedRadioButtonId() == q2_answer ) {
            return true;
        }
        return false;
    }

    //  RadioGroup for Question 3, check if the answer is correct
    private boolean checkQuestion3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup3);

        if( rg.getCheckedRadioButtonId() == q3_answer ) {
            return true;
        }
        return false;
    }

    //  CheckBox for Question 4, check if the answers are correct
    private boolean checkQuestion4() {
        CheckBox cbox2 = (CheckBox) findViewById(R.id.Kalpis);
        CheckBox cbox3 = (CheckBox) findViewById(R.id.Pithos);

        if (cbox2.isChecked() && cbox3.isChecked()) {
            return true;
        }
        return false;
    }


    //  EditText for Question 5, check if the answers is correct
    private boolean checkQuestion5() {
        EditText questionText = (EditText)findViewById(R.id.Troy);
        return questionText.getText().toString().equalsIgnoreCase(q5_answer);
    }
}