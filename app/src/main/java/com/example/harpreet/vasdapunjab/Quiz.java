package com.example.harpreet.vasdapunjab;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class Quiz extends Fragment {

    TextView mScore,mQuestion;
    Button mChoice1,mChoice2,mChoice3,mChoice4;
    int Score;
    String mAnswer;
    int mQuestionNumber;
    FirebaseDatabase database;
    DatabaseReference mQuestionRef,mChoice1Ref,mChoice2Ref,mChoice3Ref,mChoice4Ref,mAnswerRef;
    AlertDialog.Builder builder;
    AlertDialog alert;
    ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.quiz,container,false);


        initialize(view);

        updateQuestions();

        buttonListners();

        return view;
    }

    private void buttonListners() {

        //For Button 1
        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice1.getText().equals(mAnswer))
                {
                    mQuestionNumber++;
                    Score = Score +1;
                    if(Score<=20)
                    updateScores(Score);
                    if(mQuestionNumber<=19) {
                        updateQuestions();
                    }
                    if(mQuestionNumber==20)
                    {
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                       // getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();
                                    }
                                });
                        alert = builder.create();
                        alert.show();
                    }
                }
                else
                {
                    mQuestionNumber++;
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //For Button 2
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice2.getText().equals(mAnswer))
                {
                    mQuestionNumber++;
                    Score = Score +1;
                    if(Score<=20)
                    updateScores(Score);
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    mQuestionNumber++;
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //For Button 3
        mChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice3.getText().equals(mAnswer))
                {
                    mQuestionNumber++;
                    Score = Score +1;
                    if(Score<=20)
                    updateScores(Score);
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    mQuestionNumber++;
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //For Button 4
        mChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mChoice4.getText().equals(mAnswer))
                {
                    mQuestionNumber++;
                    Score = Score +1;
                    if(Score<=20)
                    updateScores(Score);
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                       // getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    mQuestionNumber++;
                    if(mQuestionNumber<=19)
                    updateQuestions();
                    if(mQuestionNumber==20)
                    {
                        builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Your Score is:- "+Score+"/20")
                                .setCancelable(false)
                                .setTitle("Quiz Completed")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                       // getFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home()).commit();

                                    }
                                });
                        alert = builder.create();
                        alert.show();
                        //Toast.makeText(getActivity(), "Last Question", Toast.LENGTH_SHORT).show();
                    }                }
            }
        });

    }

    private void updateScores(int score)
    {
        mScore.setText(""+score);
    }


    private void initialize(View view) {

        mScore = view.findViewById(R.id.score);
        mQuestion = view.findViewById(R.id.question);

        mChoice1 = view.findViewById(R.id.choice1);
        mChoice2 = view.findViewById(R.id.choice2);
        mChoice3 = view.findViewById(R.id.choice3);
        mChoice4 = view.findViewById(R.id.choice4);

        mQuestionNumber = 0;
        Score = 0;

        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Please Wait");
        dialog.setMessage("Data is being Loaded");
        dialog.show();



    }

    private void updateQuestions() {

        database = FirebaseDatabase.getInstance();
        mQuestionRef = database.getReference(mQuestionNumber+"/question/");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String question = dataSnapshot.getValue().toString();
                mQuestion.setText(question);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChoice1Ref = database.getReference(mQuestionNumber+"/choice1/");
        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice1 = dataSnapshot.getValue().toString();
                mChoice1.setText(choice1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChoice2Ref = database.getReference(mQuestionNumber+"/choice2/");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice2 = dataSnapshot.getValue().toString();
                mChoice2.setText(choice2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChoice3Ref = database.getReference(mQuestionNumber+"/choice3/");
        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice3 = dataSnapshot.getValue().toString();
                mChoice3.setText(choice3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mChoice4Ref = database.getReference(mQuestionNumber+"/choice4/");
        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String choice4 = dataSnapshot.getValue().toString();
                mChoice4.setText(choice4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mAnswerRef = database.getReference(mQuestionNumber+"/answer/");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //mQuestionNumber++;
        //Toast.makeText(getActivity(), ""+mQuestionNumber, Toast.LENGTH_SHORT).show();
        
    }
}
