package com.example.myvote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 EditText emailId , password ;
 Button btnSignIn;
 TextView tvSignIN;
 FirebaseAuth mfirebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirebaseAuth = FirebaseAuth.getInstance();
        emailId= findViewById(R.id.emailidtv);
        password = findViewById(R.id.passworDtv);
        tvSignIN = findViewById(R.id.tVsignIn);
        btnSignIn = findViewById(R.id.btnSign);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Please Enter email .... ");
                    emailId.requestFocus();

                }else if(pwd.isEmpty()){
                    password.setError("Please enter error ... ");
                    password.requestFocus();

                }else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter both Email and Password",Toast.LENGTH_LONG);

                } else if (!(email.isEmpty() && pwd.isEmpty())){
                    mfirebaseAuth.createUserWithEmailAndPassword(email , pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"SignUp unsuccessful try please try again", Toast.LENGTH_LONG);
                            }else {
                                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error has Occured!", Toast.LENGTH_LONG);
                }
            }
        });
        tvSignIN.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(MainActivity.this,LoginActivity.class);
                                            startActivity(i);
                                        }
                                    }

        );

    }
}
