package com.example.harpreet.vasdapunjab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForQuants extends AppCompatActivity
{
    private ExpandableRelativeLayout introContent;
    private ExpandableRelativeLayout introContent2;
    private ExpandableRelativeLayout introContent3;
    private ExpandableRelativeLayout introContent4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_course_for_quants);

    }


    public void showContent(View view)
    {
        introContent =(ExpandableRelativeLayout) findViewById(R.id.Inroduction_content);
        introContent.toggle();
    }
    public void showContent2(View view)
    {
        introContent2 =(ExpandableRelativeLayout)findViewById(R.id.id_WHY_TO_USE_CPP);
        introContent2.toggle();
    }
    public void showContent3(View view)
    {
        introContent3 =(ExpandableRelativeLayout)findViewById(R.id.id_Data_Type);
        introContent3.toggle();
    }
    public void showContent4(View view)
    {
        introContent4 =(ExpandableRelativeLayout)findViewById(R.id.id_Basic_syntax);
        introContent4.toggle();
    }
}