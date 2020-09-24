package com.example.greenflag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
        "(?=.*[0-9])" +
                    "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=.\\S+$).{6,}$");
    private static final Pattern PASSWORD_PATTERNS =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=.\\S+$).{6,}$");
    private EditText Email;
    private EditText Password;
    private EditText Password2;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Email = findViewById(R.id.EmailAddress);
        Password = findViewById(R.id.Password);
        Password2 = findViewById(R.id.Password2);
    }

    private boolean validateEmail() {
        String emailInput = Email.getEditableText().toString().trim();

        if (emailInput.isEmpty()) {
            Email.setError("please check email");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Email.setError("please enter a correct email address");
            return false;
        }else{
        } {
            Email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = Password.getEditableText().toString().trim();
        if (passwordInput.isEmpty()) {
            Password.setError("please enter password");



            return false;

        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Password.setError("password to weak");
            return false;
        } else
        {
            Password.setError(null);
            return true;
        }
    }

    /*}else{
Password.setError("password does not match");

Password2.setError("password not match");

if (!passwordInput.equals(Password2)) {
        }else {
            Password.setError("pass not match");
            }

     */

    private boolean validatePassword2() {
        String password2Input = Password2.getEditableText().toString().trim();
        if (Password2.equals(Password)) {

        }else{
            Password2.setError("password not match");

            return false;
        } if (password2Input.isEmpty()) {
            Password2.setError("please enter password");
            return false;


        } else if (!PASSWORD_PATTERNS.matcher(password2Input).matches()) {
            Password2.setError("password to weak");
            return false;
        } else {
        }{
            Password2.setError(null);
            return true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");

    }


    public void confirminput(View view) {
        if (!validateEmail() | !validatePassword() | !validatePassword2()) {
            return;
        }
        String input = "Email: " + Email.getEditableText().toString();
        input += "\n";
        input += "Password" + Password.getEditableText().toString();
        input += "\n";
        input += "Password again" + Password2.getEditableText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }
}
