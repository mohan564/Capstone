package com.example.harpreet.vasdapunjab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentCourseForC extends AppCompatActivity
{
    private cpp_Adapter listAdapter;
    private ExpandableListView listView;
    private List<String > list;
    private HashMap<String,List<String>> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_course_for_c);
        listView=findViewById(R.id.C_Expandable);
        initdata();
        listAdapter=new cpp_Adapter(this,list,hashMap);
        listView.setAdapter(listAdapter);
    }

    private void initdata() {
        list = new ArrayList<>();
        hashMap = new HashMap<>();
        list.add("INTRODUCTION");
        list.add("WHY TO USE C?");
        list.add("Basic Syntax");
        list.add("Data Type");
        list.add("Varibles");
        list.add("Operator C");
        list.add("Functions");
        list.add("Arrays");
        list.add("Pointer");
        list.add("Loops in C");
        list.add("Structure and Union");
        list.add("File Input/output");
        list.add("Memory Managemnet");


        List<String> Topic1 = new ArrayList<>();
        Topic1.add(getString(R.string.Introducation1));


        List<String> Topic2 = new ArrayList<>();
        Topic2.add(getString(R.string.Why_to_use_c11));


        List<String> Topic3 = new ArrayList<>();
        Topic3.add(getString(R.string.Topic));


        List<String> Topic4 = new ArrayList<>();
        Topic4.add(getString(R.string.data_type_c));

        List<String> Topic5 = new ArrayList<>();
        Topic5.add(getString(R.string.variables_c));


        List<String> Topic6 = new ArrayList<>();
        Topic6.add(getString(R.string.Opterators_c));

        List<String> Topic7 = new ArrayList<>();
        Topic6.add(getString(R.string.Functions));

        List<String> Topic8 = new ArrayList<>();
        Topic8.add(getString(R.string.arrays_c));

        List<String> Topic9 = new ArrayList<>();
        Topic9.add(getString(R.string.Ponters_c));

        List<String> Topic10 = new ArrayList<>();
        Topic10.add(getString(R.string.loops_c));

        List<String> Topic11 = new ArrayList<>();
        Topic11.add(getString(R.string.strucure_union));

        List<String> Topic12 = new ArrayList<>();
        Topic12.add(getString(R.string.File_c));

        List<String> Topic13 = new ArrayList<>();
        Topic13.add(getString(R.string.Memory_Managemet_c));


        hashMap.put(list.get(0), Topic1);
        hashMap.put(list.get(1), Topic2);
        hashMap.put(list.get(2), Topic3);
        hashMap.put(list.get(3), Topic4);
        hashMap.put(list.get(4), Topic5);
        hashMap.put(list.get(5), Topic6);
        hashMap.put(list.get(6), Topic7);
        hashMap.put(list.get(7), Topic8);
        hashMap.put(list.get(8), Topic9);
        hashMap.put(list.get(9), Topic10);
        hashMap.put(list.get(10), Topic11);
        hashMap.put(list.get(11), Topic12);
        hashMap.put(list.get(12), Topic13);
    }
    }

