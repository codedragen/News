package com.cl.news.modules.news.newsdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.cl.news.R;

/**
 * Created by Administrator on 2017/3/11 0011.
 */

public class NewsDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        toolbar=(Toolbar)findViewById(R.id.activity_newsdetail_toolbar);
        webview=(WebView)findViewById(R.id.activity_newsdetail_webview);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        Intent intent = getIntent();
        String URL=intent.getStringExtra("URL");


    }
}
