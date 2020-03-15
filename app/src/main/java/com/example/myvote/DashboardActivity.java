package com.example.myvote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageButton generalInfoButton = findViewById(R.id.general_info_button);
        ImageButton forumInfoButton = findViewById(R.id.forum_button);
        ImageButton voteButton = findViewById(R.id.vote_button);
        ImageButton candidateButton = findViewById(R.id.candidate_button);


        generalInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, GeneralInfoActivity.class );
                startActivity(intent);
            }
        });

        forumInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ForumActivity.class );
                startActivity(intent);
            }
        });

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, VoteConfirmation.class );
                startActivity(intent);
            }
        });

         candidateButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(DashboardActivity.this, CandidatesActivity.class );
                 startActivity(intent);
             }
         });

    }
}
