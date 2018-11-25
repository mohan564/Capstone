package com.example.harpreet.vasdapunjab;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForCPP extends AppCompatActivity
{
    private cpp_Adapter listAdapter;
    private ExpandableListView listView;
    private List<String > list;
    private  HashMap<String,List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_content_course_for_cpp);
        listView=(ExpandableListView)findViewById(R.id.Cpp_Expandable);
        initdata();
        listAdapter=new cpp_Adapter(this,list,hashMap);
        listView.setAdapter(listAdapter);


        }

    private void initdata()
    {
        list=new ArrayList<>();
        hashMap=new HashMap<>();
        list.add("INTRODUCTION");
        list.add("Why to use cpp?");
        list.add("Data Types");
        list.add("Variables");
        list.add("Operators");
        list.add("Functions");
        list.add("Inheritance");
        list.add("Polymorphism");
        list.add("Abstraction");
        list.add("Encapsulations");
        list.add("Interfaces");
        list.add("Files");

        List<String> Topic1=new ArrayList<>();
        Topic1.add(getString(R.string.introduction1));


        List<String> Topic2=new ArrayList<>();
        Topic2.add(getString(R.string.why_to_use_cpp));


        List<String> Topic3=new ArrayList<>();
        Topic3.add(getString(R.string.data_types_cpp));


        List<String> Topic4=new ArrayList<>();
        Topic4.add(getString(R.string.variables_cpp));

        List<String> Topic5=new ArrayList<>();
        Topic5.add(getString(R.string.operators_cpp));


        List<String> Topic6=new ArrayList<>();
        Topic6.add(getString(R.string.Functios_cpp));

        List<String> Topic7=new ArrayList<>();
        Topic7.add(getString(R.string.Inheritance_cpp));

        List<String> Topic8=new ArrayList<>();
        Topic8.add(getString(R.string.poly_cpp));

        List<String> Topic9=new ArrayList<>();
        Topic9.add(getString(R.string.Abstraction_cpp));
        List<String> Topic10=new ArrayList<>();
        Topic10.add(getString(R.string.Encapsulation_cpp));
        List<String> Topic11=new ArrayList<>();
        Topic11.add(getString(R.string.Interfaces_cpp));
        List<String> Topic12=new ArrayList<>();
        Topic12.add(getString(R.string.files_cpp));


        hashMap.put(list.get(0),Topic1);
        hashMap.put(list.get(1),Topic2);
        hashMap.put(list.get(2),Topic3);
        hashMap.put(list.get(3),Topic4);
        hashMap.put(list.get(4),Topic5);
        hashMap.put(list.get(5),Topic6);
        hashMap.put(list.get(6),Topic7);
        hashMap.put(list.get(7),Topic8);
        hashMap.put(list.get(8),Topic9);
        hashMap.put(list.get(9),Topic10);
        hashMap.put(list.get(10),Topic11);
        hashMap.put(list.get(11),Topic12);


    }
}

