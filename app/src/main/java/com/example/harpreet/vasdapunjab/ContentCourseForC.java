package com.example.harpreet.vasdapunjab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Switch;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForC extends AppCompatActivity
{
    Switch my_switch;
    private ExpandableRelativeLayout introContent;
    private ExpandableRelativeLayout introContent2;
    private ExpandableRelativeLayout introContent3;
    private ExpandableRelativeLayout introContent4;
    private ExpandableRelativeLayout introContent5;
    private ExpandableRelativeLayout introContent6;
    private ExpandableRelativeLayout introContent7;
    private ExpandableRelativeLayout introContent8;
    private ExpandableRelativeLayout introContent9;
    private ExpandableRelativeLayout introContent10;
    private ExpandableRelativeLayout introContent11;
    private ExpandableRelativeLayout introContent12;
    private ExpandableRelativeLayout introContent13;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_course_for_c);

    }



    public void showContent(View view)
    {
        introContent =(ExpandableRelativeLayout) findViewById(R.id.Inroduction_content);
        introContent.toggle();
    }

    public void showContent2(View view)
    {
     introContent2 =(ExpandableRelativeLayout)findViewById(R.id.id_WHY_TO_USE_C);
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

    public void showContent5(View view)
    {
        introContent5 =(ExpandableRelativeLayout)findViewById(R.id.id_Varibles);
        introContent5.toggle();

    }

    public void showContent6(View view)
    {
        introContent6 =(ExpandableRelativeLayout)findViewById(R.id.id_Operator_C);
        introContent6.toggle();

    }
    public void showContent7(View view)
    {
        introContent7 =(ExpandableRelativeLayout)findViewById(R.id.id_Functions);
        introContent7.toggle();

    }
    public void showContent8(View view)
    {
        introContent8 =(ExpandableRelativeLayout)findViewById(R.id.id_Arrays);
        introContent8.toggle();

    }
    public void showContent9(View view)
    {
        introContent9 =(ExpandableRelativeLayout)findViewById(R.id.id_Pointer);
        introContent9.toggle();

    }
    public void showContent10(View view)
    {
        introContent10 =(ExpandableRelativeLayout)findViewById(R.id.id_Loops);
        introContent10.toggle();

    }
    public void showContent11(View view)
    {
        introContent11 =(ExpandableRelativeLayout)findViewById(R.id.id_Structure_Union);
        introContent11.toggle();

    }
    public void showContent12(View view)
    {
        introContent12 =(ExpandableRelativeLayout)findViewById(R.id.id_File);
        introContent12.toggle();

    }
    public void showContent13(View view)
    {
        introContent13 =(ExpandableRelativeLayout)findViewById(R.id.id_File_Mnagement);
        introContent13.toggle();

    }
}

