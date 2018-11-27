package com.example.harpreet.vasdapunjab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up_Activity extends AppCompatActivity {

    TextInputLayout layoutEmail,layoutPassword,layoutCpassword,layoutName;
    EditText user,pasword,Uname,cpassword;
    FirebaseAuth Auth;
    ProgressDialog progressDialog;
    FirebaseUser firebaseUser;
    Pattern pattern;
    Button signup;
    String email;
    Matcher matcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign__up_);
        initialize();
    }

    public void signup(View view)
    {
        boolean flag = true;
        email = user.getText().toString().trim();
        String password = pasword.getText().toString().trim();
        String cPassword = cpassword.getText().toString().trim();
        String name = Uname.getText().toString().trim();

        boolean flag1 = validation(email,password,cPassword,name,flag);

        if(flag1){

            progressDialog.setMessage("Signing Up");
            progressDialog.show();
            ;

            Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Sign_Up_Activity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        firebaseUser = Auth.getCurrentUser();
                        progressDialog.dismiss();
                        Toast.makeText(Sign_Up_Activity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                        verify();

                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(Sign_Up_Activity.this, "Not Done", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private boolean validation(String email, String password, String cPassword, String name, boolean flag) {

        pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);

        if(matcher.find()!=true)
        {
            layoutEmail.setError("Please Enter Valid Email");
            flag = false;
        }
        else {
            layoutEmail.setErrorEnabled(false);
        }
        if(password.equals(cPassword)==false)
        {
            layoutCpassword.setError("Password and Confirm Password Must be Same");
            flag = false;
        }
        else
        {
            layoutCpassword.setErrorEnabled(false);
        }
        if(password.length() < 6)
        {
            layoutPassword.setError("Minimum length for Password is 6");
            flag = false;
        }
        else
        {
            layoutPassword.setErrorEnabled(false);
        }
        if(name.isEmpty())
        {
            layoutName.setError("Plaese Enter Name");
            flag = false;
        }
        else
        {
            layoutName.setErrorEnabled(false);
        }

        return flag;
    }


    public void initialize()
    {
        user = findViewById(R.id.email);
        pasword = findViewById(R.id.password);
        Uname  =findViewById(R.id.EditName);
        cpassword = findViewById(R.id.confirmPassword);
        Auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        signup = findViewById(R.id.signup);
        layoutEmail = findViewById(R.id.layoutEmail);
        layoutPassword = findViewById(R.id.layoutPassword);
        layoutCpassword = findViewById(R.id.layoutConfirmPassword);
        layoutName = findViewById(R.id.layoutname);
    }

    public void verify()
    {
        firebaseUser.sendEmailVerification().addOnCompleteListener(Sign_Up_Activity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Sign_Up_Activity.this, "Verification Email Sent To "+email, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Sign_Up_Activity.this, "Email Sending Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void GotoSignIn(View view) {

        Intent intent = new Intent(this,First_Screen.class);
        startActivity(intent);
    }
}

