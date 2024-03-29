package com.example.javagithubexplorer;

//public class AuthActivity {
//}

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//public class AuthActivity {
//}
public class AuthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // By default load the LoginFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow();
        }
    }

    public void showSignup() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SignupFragment.newInstance())
                .addToBackStack(null) // Allows user to go back to login screen
                .commit();
    }

    public void showLogin() {
        getSupportFragmentManager().popBackStack(); // Returns to the previous fragment, which is the login fragment
    }

    public void showReposList() {
        Log.d("AuthActivity", "showReposList() method called"); // Add this log statement
        Intent intent = new Intent(this, ReposListActivity.class);
        startActivity(intent);

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, ReposListActivity.newInstance())
//                .addToBackStack(null) // Allows user to go back to login screen
//                .commit();
//        }
    }
}