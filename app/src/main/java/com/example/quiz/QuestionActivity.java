package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    Question[] questions=new Question[10];
    TextView text, tvQuestionNumber;

    Intent come, goResult;
    Button btnNext,btnAnswer1,btnAnswer2;
    int i, points=0, point;
    int randomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        come=getIntent();

        text=findViewById(R.id.text);
        tvQuestionNumber=findViewById(R.id.tvQuestionNumber);
        btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnAnswer1=findViewById(R.id.btnAnswer1);
        btnAnswer2=findViewById(R.id.btnAnswer2);

        String[] questionID = getResources().getStringArray(R.array.array);
        String[] questionAns = getResources().getStringArray(R.array.arrayAnswers);
        String[] questionWrAns = getResources().getStringArray(R.array.arrayWrongAnswers);


        for (i=0; i<questions.length;i++) {
            questions[i] = new Question(questionID[i],questionAns[i],
                    questionWrAns[i]);
            text.setText(questions[i].toString());
        }

        text.setText(questions[0].toString());
        tvQuestionNumber.setText("Вопрос № " + 1);
        randomNumber= 1+(int) (2*Math.random());
        if (randomNumber==1){
            btnAnswer1.setText(questions[0].getQuestionAnswer());
            btnAnswer2.setText(questions[0].getWrongQuestionAnswer());
        } else {
            btnAnswer2.setText(questions[0].getQuestionAnswer());
            btnAnswer1.setText(questions[0].getWrongQuestionAnswer());
        }

        i=1;
        points=0;
        goResult = new Intent(this, ResultActivity.class);

    }

    @Override
    public void onClick(View view) {
        points=points+point;
        tvQuestionNumber.setText("Вопрос № " + i);
        if (i<questions.length) {
            text.setText(questions[i].toString());
            randomNumber= 1+(int) (2*Math.random());
            if (randomNumber==1){
                btnAnswer1.setText(questions[i].getQuestionAnswer());
                btnAnswer2.setText(questions[i].getWrongQuestionAnswer());
            } else {
                btnAnswer2.setText(questions[i].getQuestionAnswer());
                btnAnswer1.setText(questions[i].getWrongQuestionAnswer());
            }

        } else {
            goResult.putExtra("points", points);
            startActivity(goResult);
        }
        i++;

    }

    public void aswer(View button) {

        if (button==btnAnswer1){
            if (btnAnswer1.getText().toString().equals(questions[i-1].getQuestionAnswer())) {
                // Toast.makeText(this, btnAnswer1.getText().toString(), Toast.LENGTH_SHORT).show();
                point=1;
            } else
                point=0;

        } else if (button==btnAnswer2){
            if (btnAnswer2.getText().toString().equals(questions[i-1].getQuestionAnswer())) {
                //Toast.makeText(this, btnAnswer2.getText().toString(), Toast.LENGTH_SHORT).show();
                point=1;
            } else
                point=0;
        }
    }
}