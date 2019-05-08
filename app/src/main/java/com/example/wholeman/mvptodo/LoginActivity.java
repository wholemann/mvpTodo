package com.example.wholeman.mvptodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView mTextViewCreateAccount;
    Button mButtonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        mButtonLogin = findViewById(R.id.login_btn);
        mTextViewCreateAccount = findViewById(R.id.create_account);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.start(LoginActivity.this);
            }
        });

        mTextViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.start(LoginActivity.this);
            }
        });

    }
}
