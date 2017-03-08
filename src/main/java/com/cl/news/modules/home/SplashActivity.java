package com.cl.news.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cl.news.R;

/**
 * Created by sks on 2017/3/7.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        getWindow().getDecorView().setBackgroundResource(R.mipmap.ic_launcher);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },5000);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
