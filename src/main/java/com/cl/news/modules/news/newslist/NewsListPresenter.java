package com.cl.news.modules.news.newslist;

import android.util.Log;

import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BasePresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sks on 2017/3/9.
 */

public class NewsListPresenter implements BasePresenter {

    private final NewsListView view;
    private final NewsListModel model;

    public NewsListPresenter(NewsListModel model, NewsListView view){
        this.model=model;
        this.view=view;
        view.setPresenter(this);
    }
    @Override
    public void start() {

    }

    public void getNewsList(String newsTypeId, int page){
        model.getNewsList(newsTypeId,page).subscribe(new Observer<List<NewsInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showLoading();
            }

            @Override
            public void onNext(List<NewsInfo> value) {
                Log.i("onNext",value==null?"true":"false");
               view.addData(value);
            }

            @Override
            public void onError(Throwable e) {
             view.onError(e);
            }

            @Override
            public void onComplete() {
             view.loadComplete();
            }
        });
    }


}
