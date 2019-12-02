package com.example.tennispals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditEmail, mEditPassword;
    private Button mLoginButton;
    private TextView mSignUpShortcutButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditEmail = findViewById(R.id.edit_email_login);
        mEditPassword = findViewById(R.id.edit_password);
        mLoginButton = findViewById(R.id.login_button);
        mSignUpShortcutButton = findViewById(R.id.go_to_sign_up);

        mAuth = FirebaseAuth.getInstance();

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEditEmail.getText().toString();
                String password = mEditPassword.getText().toString();

                if (email.isEmpty()) {
                    mEditEmail.setError(getResources().getString(R.string.login_no_email);
                    mEditEmail.requestFocus();
                } else if (password.isEmpty()) {
                    mEditPassword.setError(getResources().getString(R.string.login_no_password);
                    mEditPassword.requestFocus();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.singnInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(mainActivity);
                            } else if (task.isCanceled()) {
                            } else {
                                Toast.makeText(LoginActivity.this, getResources().getString(R.string.error), Toast.LENGTH_SHORT);
                            }
                        }
                    });
                }
            }
        });

        mSignUpShortcutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

}
