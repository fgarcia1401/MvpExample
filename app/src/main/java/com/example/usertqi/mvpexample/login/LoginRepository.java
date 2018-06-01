package com.example.usertqi.mvpexample.login;

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}
