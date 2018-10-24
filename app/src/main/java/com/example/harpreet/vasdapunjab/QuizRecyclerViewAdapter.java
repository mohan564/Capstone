package com.example.harpreet.vasdapunjab;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizRecyclerViewAdapter extends RecyclerView.Adapter<QuizRecyclerViewAdapter.QuizRecycleViewHolder>{

    Context mContext;
    List<quizzTopcInCpp> quizzData;

    public QuizRecyclerViewAdapter(Context mContext, List<quizzTopcInCpp> quizzData) {
        this.mContext = mContext;
        this.quizzData = quizzData;
    }

    @Override
    public QuizRecycleViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.quizztopicincpp,parent,false);
        final QuizRecycleViewHolder quizRecycleViewHolder = new QuizRecycleViewHolder(v);

       // mainquizactivityDisplay mainQuizDisplay =  new mainquizactivityDisplay();
       // mainQuizDisplay.setContentView(R.layout.activity_mainquizdisplay);

        quizRecycleViewHolder.linearLayoutQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Important Line for
                Toast.makeText(mContext,"Just for Testing"+String.valueOf(quizRecycleViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext,mainquizactivityDisplay.class);
                    mContext.startActivity(intent);


            }
        });

        return quizRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder( QuizRecycleViewHolder holder, int position) {
        holder.topicName.setText(quizzData.get(position).getTopicName());

    }

    @Override
    public int getItemCount() {
        return quizzData.size();
    }

    public static class QuizRecycleViewHolder extends RecyclerView.ViewHolder{

        private TextView topicName;
        private LinearLayout linearLayoutQuiz;
        public QuizRecycleViewHolder(View itemView) {
            super(itemView);
            linearLayoutQuiz = (LinearLayout)itemView.findViewById(R.id.quizLinearLayout);
            topicName = (TextView)itemView.findViewById(R.id.cppQuizText);
        }
    }
}
