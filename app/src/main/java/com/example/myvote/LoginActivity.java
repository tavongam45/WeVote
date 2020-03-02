package com.example.myvote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        emailId= findViewById(R.id.emailidtv);
        password = findViewById(R.id.passworDtv);
        tvSignUp = findViewById(R.id.tVsignIn);
        btnSignIn = findViewById(R.id.btnSign);

        mAuthStateListner = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseAuth = mfirebaseAuth.getCurrentUser();


                if( mFirebaseUser != null ){
                    Toast.makeText(LoginActivity.this,"You are logged in")
                }
            }
        }

    }
}
