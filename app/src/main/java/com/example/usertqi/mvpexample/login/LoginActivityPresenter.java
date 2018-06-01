package com.example.usertqi.mvpexample.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter  implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View mView;
    private LoginActivityMVP.Model mModel;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.mModel = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.mView = view;
    }

    @Override
    public void loginButtonClicked() {

        if (mView != null) {

            if(mView.getFirstName().trim().equals("") || mView.getLastName().trim().equals("")){
                mView.showInputError();
            } else {
                mModel.createUser(mView.getFirstName(), mView.getLastName());
                mView.showUserSavedMessage();
            }

        }

    }

    @Override
    public void getCurrentUser() {
        User user = mModel.getUser();

        if ( user == null ) {
            if ( mView != null ) {
                mView.showUserNotAvailable();
            }
        } else {
            if ( mView != null ) {
                mView.setFirstName(user.getFirstName());
                mView.setLastName(user.getLastName());
            }
        }

    }

}
