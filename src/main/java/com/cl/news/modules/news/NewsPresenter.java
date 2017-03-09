package com.cl.news.modules.news;

import com.cl.news.http.NewsApi;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BasePresenter;
import com.cl.news.modules.base.BaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sks on 2017/3/8.
 */

public class NewsPresenter implements BasePresenter {


    private final NewsView view;
    private final NewsModel model;

    NewsPresenter(NewsView view, NewsModel model){
        this.view=view;
        this.model=model;
        view.setPresenter(this);
    }

    @Override
    public void start() {
       model.getNewsList("T1348647909107", 60, new Observer<NewsInfo>() {
           @Override
           public void onSubscribe(Disposable d) {
               view.showLoading();
           }

           @Override
           public void onNext(NewsInfo value) {
            view.addData(value);
           }

           @Override
           public void onError(Throwable e) {
             view.showError(e);
           }

           @Override
           public void onComplete() {
           view.loadComplete();
           }
       });
    }
}
