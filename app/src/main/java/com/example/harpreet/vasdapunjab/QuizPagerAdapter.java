package com.example.harpreet.vasdapunjab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class QuizPagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
     QuizPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
         switch (position)
         {
             case 0:
                 return new CPPQuizFragment();

             case 1:
                 return new javaProgramFragm();

             case 2:
                 return new DataStructureFragm();

             default:
                 return null;
         }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
