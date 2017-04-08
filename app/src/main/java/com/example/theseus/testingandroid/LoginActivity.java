package com.example.theseus.testingandroid;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        error=(TextView)findViewById(R.id.error);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText=email.getText().toString();
                String passwordText=password.getText().toString();
                if(!LoginUtils.isValidEmailAddress(emailText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(R.string.invalid_email));
                }
                else if(!LoginUtils.checkPasswordSize(passwordText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(R.string.password_length_too_small));
                }
                else if(!LoginUtils.checkAllSpacesInPassword(passwordText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(R.string.password_all_spaces));
                }else {
                    error.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        error.setTextColor(getColor(R.color.blue_500));
                    }
                    error.setText(getString(R.string.login_success));
                }

            }
        });
    }
}
