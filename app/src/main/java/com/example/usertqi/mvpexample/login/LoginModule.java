package com.example.usertqi.mvpexample.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public  LoginActivityMVP.Presenter provideLoginActivityPresente(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }

}
