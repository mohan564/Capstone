package com.example.harpreet.vasdapunjab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class First_Screen extends AppCompatActivity {

    TextInputLayout inputName, inputPassword;
    EditText Uname, password;
    TextView sign_up;
    Intent intent;
    ProgressDialog progressDialog;
    FirebaseAuth Auth;
    Boolean islogin = false;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__screen);
        initialize();
    }

    //saare varibale initialize karn layi method
    private void initialize() {
        Auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        inputName = findViewById(R.id.inputName);
        inputPassword = findViewById(R.id.inputPassword);
        Uname  = findViewById(R.id.name);
        password = findViewById(R.id.password);
        sign_up  = findViewById(R.id.sign_up);
        Uname.setText("");
        password.setText("");
    }



    public void signInMethod(View view) {
        if (Uname.getText().toString().length() == 0 || password.getText().toString().length() == 0) {
            Toast.makeText(this, "Enter Email or Password", Toast.LENGTH_SHORT).show();
        } else {

            final String email = Uname.getText().toString().trim();
            String pasword = password.getText().toString().trim();


            progressDialog.setMessage("Signing In");
            progressDialog.show();

            Auth.signInWithEmailAndPassword(email, pasword).addOnCompleteListener(First_Screen.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(First_Screen.this, "Success", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Intent intent = new Intent(First_Screen.this, MainActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                        islogin = true;
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(First_Screen.this);
                        sharedPreferences.edit().putBoolean("Islogin",islogin).commit();
                        finish();

                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(First_Screen.this, "Not Done", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }

    public void signUpMethod(View view) {

        if (sign_up.getId()==view.getId())
        {

            intent = new Intent(this,Sign_Up_Activity.class);
            startActivity(intent);
            Uname.setText("");
            password.setText("");

        }
    }

    public void forgotPasswordMethod(View view) {

        if(Uname.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
        }
        else {
            Auth.getInstance().sendPasswordResetEmail(Uname.getText().toString().trim()).
                    addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isComplete()) {
                                Toast.makeText(First_Screen.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(First_Screen.this, "Please Enter Email Above", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }
}
