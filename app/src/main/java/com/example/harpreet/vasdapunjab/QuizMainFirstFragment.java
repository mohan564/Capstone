package com.example.harpreet.vasdapunjab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuizMainFirstFragment extends Fragment {

    TextView textView;
    View quizMainFragview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       quizMainFragview = inflater.inflate(R.layout.quizmainfirstfrag,container,false);
     //  textView = quizMainFragview.findViewById(R.id.textInQuiz);
      // String message = getArguments().getString("message");
     //  textView.setText(message);

        return quizMainFragview;
    }
}
