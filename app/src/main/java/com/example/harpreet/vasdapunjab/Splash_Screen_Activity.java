package com.example.harpreet.vasdapunjab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash_Screen_Activity extends AppCompatActivity {

    private static int time = 2500;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash__screen_);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final boolean islogin = preferences.getBoolean("Islogin",false);

        //2 sec screen nu rukan vaaste thread
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(islogin) {
                    Intent intent = new Intent(Splash_Screen_Activity.this, Resend_Mail_Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(Splash_Screen_Activity.this, First_Screen.class);
                    startActivity(intent);
                }
                finish();

            }
        },time);



    }
}
