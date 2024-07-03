package com.example.mvp;

public class MainActivityPresenter implements MainActivityContract.presenter{

    MainActivityContract.view view;

    public MainActivityPresenter(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if(email.equals("admin@gmail.com") && password.equals("admin")){
            view.onSuccess("Successful");
        }else{
            view.onError("Wrong email or Password");
        }
    }
}
