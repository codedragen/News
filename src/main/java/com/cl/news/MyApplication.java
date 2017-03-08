package com.cl.news;

import android.app.Application;
import android.content.Context;

import io.reactivex.Observable;

/**
 * Created by sks on 2017/3/7.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

    }

    public static Context getContext(){
        return context;
    }
}
