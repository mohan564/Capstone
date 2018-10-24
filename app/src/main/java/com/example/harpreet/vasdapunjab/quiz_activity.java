package com.example.harpreet.vasdapunjab;

import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class quiz_activity extends AppCompatActivity {

  Toolbar Quiztoolbar;
  TabLayout quizTablayout;
  ViewPager QuizViewPagerFragm;
  QuizPagerAdapter quizPagerAdapter;
  TabItem tabCppFragm;
  TabItem tabJavaFragm;
  TabItem tabDatafragm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activity);

        Quiztoolbar = (Toolbar)findViewById(R.id.QuiztoolBar);
        setSupportActionBar(Quiztoolbar);

        quizTablayout =     findViewById(R.id.quizTabLayout);
        QuizViewPagerFragm = findViewById(R.id.quizViewPager);
        tabCppFragm = findViewById(R.id.tabItemCPPprogramming);
        tabJavaFragm = findViewById(R.id.tabItemJavaprogramming);
        tabDatafragm = findViewById(R.id.tabItemDataStructure);

        quizPagerAdapter = new QuizPagerAdapter(getSupportFragmentManager(),quizTablayout.getTabCount());
        QuizViewPagerFragm.setAdapter(quizPagerAdapter);

        quizTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                QuizViewPagerFragm.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 1)
                {
                    Quiztoolbar.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorAccent));
                    quizTablayout.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorAccent));
                       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                       {
                           getWindow().setStatusBarColor(ContextCompat.getColor(quiz_activity.this,R.color.colorAccent));
                       }
                }
                else if(tab.getPosition() == 2)
                {
                    Quiztoolbar.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorSecondaryDark));
                    quizTablayout.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorSecondaryDark));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(quiz_activity.this,R.color.colorSecondaryDark));
                    }
                }
                else
                {
                    Quiztoolbar.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorPrimaryDark));
                    quizTablayout.setBackgroundColor(ContextCompat.getColor(quiz_activity.this,R.color.colorPrimaryDark));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(quiz_activity.this,R.color.colorPrimaryDark));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        QuizViewPagerFragm.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(quizTablayout));
    }
}
