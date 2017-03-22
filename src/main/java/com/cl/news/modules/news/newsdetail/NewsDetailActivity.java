package com.cl.news.modules.news.newsdetail;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.cl.news.R;
import com.cl.news.http.bean.NewsDetailInfo;
import com.zzhoujay.richtext.RichText;

/**
 * Created by Administrator on 2017/3/11 0011.
 */

public class NewsDetailActivity extends AppCompatActivity implements NewsDetailView{
    private Toolbar toolbar;
    private WebView webview;
    private String newsid;
    private NewsDetailPresenter presenter;
    private ProgressDialog loadDialog;
    private TextView tv_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        toolbar=(Toolbar)findViewById(R.id.activity_newsdetail_toolbar);
        tv_content= (TextView) findViewById(R.id.newsdetail_content);
        Intent intent = getIntent();
        newsid=intent.getStringExtra("newsId");
        loadDialog=new ProgressDialog(this,R.style.Theme_AppCompat_Dialog_Alert);
        loadDialog.setMessage("正在获取新闻详情");
       presenter=new NewsDetailPresenter(new NewsDetailModel(),this);
        presenter.getNewsDetail(newsid);

    }

    @Override
    public void setPresenter(NewsDetailPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showLoad() {
      loadDialog.show();
    }

    @Override
    public void addData(NewsDetailInfo value) {

        RichText.from(value.getBody()).into(tv_content);
    }

    @Override
    public void onError(Throwable e) {
      loadDialog.dismiss();
    }

    @Override
    public void onComplete() {
         loadDialog.dismiss();
    }
}
