package com.cl.news.modules.news;

import android.support.v4.app.Fragment;

import com.cl.news.http.NewsApi;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BasePresenter;
import com.cl.news.modules.base.BaseView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sks on 2017/3/8.
 */

public class NewsPresenter implements BasePresenter {


    private final NewsView view;
    private final NewsModel model;

    public NewsPresenter(NewsView view, NewsModel model){
        this.view=view;
        this.model=model;
        view.setPresenter(this);
    }

    @Override
    public void start() {
       model.initData(new NewsModel.CallBack() {
           @Override
           public void onDataInit(List<Fragment> fragments, List<String> titles) {
               view.initData(fragments,titles);
           }
       });
    }
}
