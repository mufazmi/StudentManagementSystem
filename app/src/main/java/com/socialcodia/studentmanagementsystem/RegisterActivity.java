package com.socialcodia.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {


    private EditText inputName, inputEmail, inputPassword, inputConfirmPassword;
    private TextView tvLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        tvLogin = findViewById(R.id.tvLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });


    }

    private void validateData()
    {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String confirmPassword = inputConfirmPassword.getText().toString().trim();

        if (name.isEmpty())
        {
            inputName.setError("Enter Name");
            inputName.requestFocus();
        }
        else if (name.length()<3 || name.length()>30)
        {
            inputName.setError("Name Valid Name");
            inputName.requestFocus();
        }
        else if (email.isEmpty())
        {
            inputEmail.setError("Enter Email Address");
            inputEmail.requestFocus();
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.length()>50)
        {
            inputEmail.setError("Enter Valid Email");
            inputEmail.requestFocus();
        }
        else if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
        }
        else if (password.length()<7 || password.length()>30)
        {
            inputPassword.setError("Enter Password Greater Than 8 Digit");
            inputPassword.requestFocus();
        }
        else if (confirmPassword.isEmpty())
        {
            inputConfirmPassword.setError("Enter Confirm Password");
            inputConfirmPassword.requestFocus();
        }
        else if (confirmPassword.length()<7 || confirmPassword.length()>30)
        {
            inputConfirmPassword.setError("Password should be greater than 8 character");
            inputConfirmPassword.requestFocus();
        }
        else if (!password.equals(confirmPassword))
        {
            inputPassword.setError("Password not matched");
            inputConfirmPassword.setError("Password not matched");
            inputPassword.requestFocus();
            inputConfirmPassword.requestFocus();
            inputPassword.setText("");
            inputConfirmPassword.setText("");
        }
        else
        {
            doRegister();
        }
    }

    private void doRegister() {
    }

}
