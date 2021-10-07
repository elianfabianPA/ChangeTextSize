package com.elian.changesizetext;

import android.app.Application;

import com.elian.changesizetext.data.model.User;

public class ChangeSizeTextApplication extends Application {

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();

        user = new User("Lourdes", "lourdes@iesportada.org");
    }

    public User getUser() {
        return user;
    }
}
