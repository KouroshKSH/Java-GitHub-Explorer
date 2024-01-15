package com.example.javagithubexplorer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.javagithubexplorer.R;

public class SignupFragment extends Fragment {
    public static Fragment newInstance() {
        return new SignupFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        Button createAccountButton = view.findViewById(R.id.create_account_button);
        Button loginButton = view.findViewById(R.id.buttonSignUp);

        createAccountButton.setOnClickListener(v -> attemptSignup());
        loginButton.setOnClickListener(v -> redirectToLogin());

        return view;
    }

    private void attemptSignup() {
        // Perform signup logic here
        // If signup is successful, you can choose to automatically log in and redirect
        // For now, we will just redirect to 2nd screen (ReposListActivity)
        redirectToReposList();
    }

    private void redirectToReposList() {
        ((AuthActivity) getActivity()).showReposList();
    }

    private void redirectToLogin() {
        ((AuthActivity) getActivity()).showLogin();
    }
}
