package com.example.usertqi.mvpexample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usertqi.daggerexample.R;
import com.example.usertqi.mvpexample.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {


    @Inject
    LoginActivityMVP.Presenter mPresenter;

    private EditText mFirstName;
    private EditText mLastName;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        mFirstName = findViewById(R.id.loginActivity_firstName_editText);
        mLastName = findViewById(R.id.loginActivity_lastName_editText);
        mBtnLogin = findViewById(R.id.loginActivity_login_button);

        mBtnLogin.setOnClickListener(v -> {
            mPresenter.loginButtonClicked();
        });


        ((App) getApplication()).getComponent().inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.setView(this);
        mPresenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return mFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mLastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this,"Error the user is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or Last name cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        mFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        mLastName.setText(lastName);
    }
}
