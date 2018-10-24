package com.example.harpreet.vasdapunjab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class QuizMainfragmentAdapter extends FragmentStatePagerAdapter {

    public QuizMainfragmentAdapter(FragmentManager fm) {
        super(fm);
    }




    @Override
    public Fragment getItem(int position) {

        QuizMainFirstFragment quizMainFirstFragment = new QuizMainFirstFragment();
        Bundle mybundle = new Bundle();
        position = position+1;
       // mybundle.putString("message","Page Nomber:"+position);

       String json = "";



        quizMainFirstFragment.setArguments(mybundle);
        return quizMainFirstFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
