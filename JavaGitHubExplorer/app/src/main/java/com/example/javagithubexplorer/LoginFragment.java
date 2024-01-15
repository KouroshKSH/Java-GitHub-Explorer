package com.example.javagithubexplorer;

//public class LoginFragment {
//}


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewLoginError;
    private Button buttonLogin;

    // todo: write the code for the database handler
//    private DatabaseHandler databaseHandler;


    public static Fragment newInstance() {
        return new LoginFragment();
    }
    // ... other methods and variables

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Initialize your views here and set up click listeners
        // For example, a button that when clicked should take you to the signup fragment
        Button signUpButton = view.findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(v -> ((AuthActivity) getActivity()).showSignup());

        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        textViewLoginError = view.findViewById(R.id.textViewLoginError);
        buttonLogin = view.findViewById(R.id.buttonLogin);

        // Initialize the DatabaseHandler
//        databaseHandler = new DatabaseHandler();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        return view;
    }

    // Method to validate user input and attempt login
    private void attemptLogin() {
        // Get input from user, validate and attempt login
        // If login is successful, transition to the main application
        // If not, show an error

        boolean loginSuccess = true;
        if (loginSuccess) {
            textViewLoginError.setText("");
            textViewLoginError.setVisibility(View.GONE);
            ((AuthActivity) getActivity()).showReposList();
        } else {
            textViewLoginError.setText("Invalid username or password.");
            textViewLoginError.setVisibility(View.VISIBLE);
        }


        // Method to validate user input and attempt login
//        private void attemptLogin() {
//            String username = editTextUsername.getText().toString();
//            String password = editTextPassword.getText().toString();
//
//            // Simple validation
//            if (username.isEmpty() || password.isEmpty()) {
//                textViewLoginError.setText("Username and password must not be empty.");
//                textViewLoginError.setVisibility(View.VISIBLE);
//            } else {
//                // Perform the login operation on a separate thread to avoid blocking the UI
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        final boolean loginSuccess = databaseHandler.validateUserPass(username, password);
//
//                        // Since we cannot update the UI from a background thread, we need to post the result back to the UI thread
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (loginSuccess) {
//                                    textViewLoginError.setText("");
//                                    textViewLoginError.setVisibility(View.GONE);
//                                    // TODO: Navigate to the next screen or activity since the login was successful
//                                } else {
//                                    textViewLoginError.setText("Invalid username or password.");
//                                    textViewLoginError.setVisibility(View.VISIBLE);
//                                }
//                            }
//                        });
//                    }
//                }).start();
//            }
//        }
    }
}
