package com.example.harpreet.vasdapunjab;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class mainquizactivityDisplay extends AppCompatActivity {

    private ViewPager myViewPager;
    private QuizMainfragmentAdapter quizMainfragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainquizdisplay);
        myViewPager = findViewById(R.id.QuizMainActivityViewPager);
        quizMainfragmentAdapter = new QuizMainfragmentAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(quizMainfragmentAdapter);
    }
}
