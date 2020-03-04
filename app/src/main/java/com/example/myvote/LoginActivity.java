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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText emailId , password ;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mfirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailidtv);
        password = findViewById(R.id.passworDtv);
        tvSignUp = findViewById(R.id.tVsignIn);
        btnSignIn = findViewById(R.id.btnSign);

        mAuthStateListner = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mfirebaseAuth.getCurrentUser();


                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "please login", Toast.LENGTH_SHORT).show();


                }

            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please Enter email .... ");
                    emailId.requestFocus();

                } else if (pwd.isEmpty()) {
                    password.setError("Please enter error ... ");
                    password.requestFocus();

                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter both Email and Password", Toast.LENGTH_LONG);

                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mfirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "login error please try again", Toast.LENGTH_LONG);

                            } else {
                                Intent intoHome = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intoHome);

                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Error has Occured!", Toast.LENGTH_LONG);
                }
            }


        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intSignup = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intSignup);


            }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mfirebaseAuth.addAuthStateListener(mAuthStateListner);
    }
}

