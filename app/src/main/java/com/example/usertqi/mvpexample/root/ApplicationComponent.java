package com.example.usertqi.mvpexample.root;

import com.example.usertqi.mvpexample.login.LoginActivity;
import com.example.usertqi.mvpexample.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
