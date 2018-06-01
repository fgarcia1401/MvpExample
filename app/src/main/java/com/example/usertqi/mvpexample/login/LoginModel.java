package com.example.usertqi.mvpexample.login;

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository mRepository;

    public LoginModel(LoginRepository repository) {
        mRepository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        mRepository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return mRepository.getUser();
    }
}
