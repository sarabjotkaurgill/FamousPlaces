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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences sharedPreferences;
    private EditText et_name, et_email, et_password, et_confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String SHARED_PREFERENCES_FILE = "com.example.famousplaces";
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);

        et_name = findViewById(R.id.register_name);
        et_email = findViewById(R.id.register_email);
        et_password = findViewById(R.id.register_password);
        et_confirmPassword = findViewById(R.id.register_confirmPassword);
        Button btn_register = findViewById(R.id.register_btn);
        TextView tv_login = findViewById(R.id.register_login);
        btn_register.setOnClickListener(this);
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_btn:
                validUserData();
                break;
            case R.id.register_login:
                Intent intent  = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void validUserData() {
        if (TextUtils.isEmpty(et_name.getText().toString().trim())) {
            et_name.setError(getString(R.string.please_enter_name));
            et_name.requestFocus();
        } else if(TextUtils.isEmpty(et_email.getText().toString().trim())) {
            et_email.setError(getString(R.string.please_enter_email));
            et_email.requestFocus();
        } else if(TextUtils.isEmpty(et_password.getText().toString().trim())) {
            et_password.setError(getString(R.string.please_enter_password));
            et_password.requestFocus();
        } else if(TextUtils.isEmpty(et_confirmPassword.getText().toString().trim())) {
            et_confirmPassword.setError(getString(R.string.please_enter_confirm_pass));
            et_confirmPassword.requestFocus();
        } else if (!et_password.getText().toString().trim().equals(et_confirmPassword.getText().toString().trim())) {
            et_confirmPassword.setError(getString(R.string.enter_same_pass));
            et_confirmPassword.requestFocus();
        } else
            sharedPreference();
    }

    private void sharedPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String EMAIL_KEY = "email";
        editor.putString(EMAIL_KEY, et_email.getText().toString());
        String PASSWORD_KEY = "password";
        editor.putString(PASSWORD_KEY, et_password.getText().toString());
        editor.apply();
        Intent intent  = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}