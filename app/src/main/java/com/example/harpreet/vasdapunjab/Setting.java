package com.example.harpreet.vasdapunjab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Setting extends Fragment {
    RatingBar ratingBar;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);
        button = view.findViewById(R.id.id_button);
        ratingBar = view.findViewById(R.id.idrating);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rate = ratingBar.getRating();
                ratingBar.setNumStars(5);
                ratingBar.setMax(5);
                Toast.makeText(getActivity(), "Your Rating is" + rate, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}