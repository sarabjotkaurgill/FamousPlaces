package com.example.famousplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String SHARED_PREFERENCES_FILE = "com.example.famousplaces";
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);

        et_email = findViewById(R.id.login_email);
        et_password = findViewById(R.id.login_password);
        Button btn_login = findViewById(R.id.login_btn);
        TextView tv_register = findViewById(R.id.login_register);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                validUserData();
                break;
            case R.id.login_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void validUserData() {
        if (TextUtils.isEmpty(et_email.getText().toString().trim())) {
            et_email.setError(getString(R.string.please_enter_email));
            et_email.requestFocus();
        } else if (TextUtils.isEmpty(et_password.getText().toString().trim())) {
            et_password.setError(getString(R.string.please_enter_password));
            et_password.requestFocus();
        } else
            sharedPreference();
    }

    private void sharedPreference() {
        String EMAIL_KEY = "email";
        String prefEmail = sharedPreferences.getString(EMAIL_KEY, "");
        String PASSWORD_KEY = "password";
        String prefPassword = sharedPreferences.getString(PASSWORD_KEY, "");
        if (et_email.getText().toString().trim().equals(prefEmail) && et_password.getText().toString().trim().equals(prefPassword)){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}