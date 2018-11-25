package com.example.harpreet.vasdapunjab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForQuants extends AppCompatActivity
{
    private cpp_Adapter listAdapter;
    private ExpandableListView listView;
    private List<String > list;
    private HashMap<String,List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_course_for_quants);
        listView=findViewById(R.id.Quants_Expandable);
        initdata();
        listAdapter=new cpp_Adapter(this,list,hashMap);
        listView.setAdapter(listAdapter);
    }

    private void initdata()
    {

        list=new ArrayList<>();
        hashMap=new HashMap<>();
        list.add("Operating Systems and Data Storage");
        list.add("Connecting to the Internet");
        list.add("Common Email Abbreviations");
        list.add("Daily Uses Abbrivation");
        list.add("QTopic4");
        list.add("QTopic5");
        List<String> Topic1=new ArrayList<>();
        Topic1.add(getString(R.string.OS_Abbrevation));


        List<String> Topic2=new ArrayList<>();
        Topic2.add(getString(R.string.Internet_abbivation));


        List<String> Topic3=new ArrayList<>();
        Topic3.add(getString(R.string.email_abbrivation));


        List<String> Topic4=new ArrayList<>();
        Topic4.add(getString(R.string.Daily_abbrivation));

        hashMap.put(list.get(0),Topic1);
        hashMap.put(list.get(1),Topic2);
        hashMap.put(list.get(2),Topic3);
        hashMap.put(list.get(3),Topic4);


    }
}