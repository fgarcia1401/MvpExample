package com.example.usertqi.mvpexample.login;

public class MemoryRepository implements LoginRepository {

    private User mUser;

    @Override
    public User getUser() {
        if (mUser == null) {
            User user = new User(0,"Fernando", "Garcia");
            return user;
        } else  {
            return mUser;
        }
    }

    @Override
    public void saveUser(User user) {

        if (user == null) {
            mUser = getUser();
        }

        this.mUser = user;
    }
}
