package com.example.harpreet.vasdapunjab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForEnglish extends AppCompatActivity
{
    private cpp_Adapter listAdapter;
    private ExpandableListView listView;
    private List<String > list;
    private HashMap<String,List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_course_for_english);
        listView=findViewById(R.id.English_Expandable);
        initdata();
        listAdapter=new cpp_Adapter(this,list,hashMap);
        listView.setAdapter(listAdapter);
    }
    private void initdata()
    {
        list=new ArrayList<>();
        hashMap=new HashMap<>();
        list.add("Netwroking Question");
        list.add("Machine based");
        list.add("Commenly asked");

        List<String> Topic1=new ArrayList<>();
        Topic1.add(getString(R.string.newt_questions));


        List<String> Topic2=new ArrayList<>();
        Topic2.add(getString(R.string.Machine_asked));


        List<String> Topic3=new ArrayList<>();
        Topic3.add(getString(R.string.Common));


        hashMap.put(list.get(0),Topic1);
        hashMap.put(list.get(1),Topic2);
        hashMap.put(list.get(2),Topic3);

    }
}
