package com.example.harpreet.vasdapunjab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CPPQuizFragment extends Fragment {

    View mView;
    private RecyclerView CppReyclerView;
    private List<quizzTopcInCpp> topicList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.cppprogrmfragm,container,false);
        CppReyclerView = mView.findViewById(R.id.recyclCppFragment);
        QuizRecyclerViewAdapter QuizrecyclerViewAdapter = new QuizRecyclerViewAdapter(getContext(),topicList);
        CppReyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CppReyclerView.setAdapter(QuizrecyclerViewAdapter);
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topicList = new ArrayList<>();
        topicList.add(new quizzTopcInCpp("Definition"));
        topicList.add(new quizzTopcInCpp("Variables"));
        topicList.add(new quizzTopcInCpp("Loops"));
        topicList.add(new quizzTopcInCpp("Functions"));
        topicList.add(new quizzTopcInCpp("Jump Statements"));
        topicList.add(new quizzTopcInCpp("Conditionals"));
        topicList.add(new quizzTopcInCpp("Operators"));
        topicList.add(new quizzTopcInCpp("Pointers"));
        topicList.add(new quizzTopcInCpp("Array"));
    }
}
