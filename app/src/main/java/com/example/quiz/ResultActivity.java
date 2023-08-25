package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {


    Intent takePoints, goAgain;
    int points;
    TextView tvResult;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult=findViewById(R.id.tvResult);
        btnBack=findViewById(R.id.btnBack);

        takePoints =getIntent();
        points = takePoints.getIntExtra("points", points);
        goAgain = new Intent(this, MainActivity.class);

        tvResult.setText("Результат:" + points);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(goAgain);
    }
}