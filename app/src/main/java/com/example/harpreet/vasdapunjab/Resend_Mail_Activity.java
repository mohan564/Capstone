package com.example.harpreet.vasdapunjab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Resend_Mail_Activity extends AppCompatActivity {

    FirebaseAuth auth;
    String Uemail;
    int time = 2000;
    TextView textView;
    FirebaseUser user;
    Button logout,resend_mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resend__mail_);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        Uemail = user.getEmail();
        textView = findViewById(R.id.verify);
        resend_mail = findViewById(R.id.resend_mail);
        logout = findViewById(R.id.logout);
        if(!user.isEmailVerified())
        {
            textView.setText("Please Verify your Email To get Access to Application");
        }
        else
        {
            textView.setText("Welcome to our App "+Uemail);
            logout.setVisibility(View.INVISIBLE);
            resend_mail.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(Resend_Mail_Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            },time);


        }


    }


    //Verification mail send karn layi method
    public void verify(View view)
    {



        user.sendEmailVerification().addOnCompleteListener(Resend_Mail_Activity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Resend_Mail_Activity.this, "Verification Email Sent To "+Uemail, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Resend_Mail_Activity.this, "Email Sending Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void logout(View view)
    {

        auth.signOut();
        Intent intent = new Intent(Resend_Mail_Activity.this,First_Screen.class);
        startActivity(intent);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putBoolean("Islogin",false).commit();
        finish();
    }

}
