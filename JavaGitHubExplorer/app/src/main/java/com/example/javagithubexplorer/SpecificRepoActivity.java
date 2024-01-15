package com.example.javagithubexplorer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpecificRepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_repo);

        // Retrieve the data from the intent
        String title = getIntent().getStringExtra("title");
        String stars = getIntent().getStringExtra("stars");
        String description = getIntent().getStringExtra("description");
        String url = getIntent().getStringExtra("url");

        // Initialize your TextViews to display the data
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView starsTextView = findViewById(R.id.starsTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        titleTextView.setText(title);
        starsTextView.setText(stars);
        descriptionTextView.setText(description);

        // Add the code for the button click listener here
        Button openWebButton = findViewById(R.id.openWebButton);
        openWebButton.setOnClickListener(v -> {
            // Create an intent to open the web browser with the repository URL
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });

        // Handle the back button click to navigate back to the list of repositories
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate back to the 2nd screen (list of repositories)
                Intent intent = new Intent(SpecificRepoActivity.this, ReposListActivity.class);
                startActivity(intent);
                finish(); // Finish this activity to avoid coming back to it when pressing the system back button
            }
        });
    }

}
