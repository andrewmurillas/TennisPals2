package com.example.tennispals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SignupNameAgeFragment extends Fragment {

    private String name;
    private int age;
    private Button nextButton;
    private Button goBackButton;

    private View container;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.signup_user_name, container, false);
        return rootView;
    }

}