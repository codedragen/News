package com.cl.news.modules.news.newsdetail;

import com.cl.news.MyApplication;
import com.cl.news.http.RetrofitService;
import com.cl.news.http.bean.NewsDetailInfo;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by sks on 2017/3/15.
 */

public class NewsDetailModel {

    private final RetrofitService service;

    public NewsDetailModel(){
        service=new RetrofitService();
        service.init(MyApplication.getContext());
    }

    public void getNewsDetail(String newsId, final Observer<NewsDetailInfo> callback){
        service.getNewsDetail(newsId).subscribe(new Observer<NewsDetailInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                callback.onSubscribe(d);
            }

            @Override
            public void onNext(NewsDetailInfo value) {
                      callback.onNext(value);
            }

            @Override
            public void onError(Throwable e) {
                 callback.onError(e);
            }

            @Override
            public void onComplete() {
                callback.onComplete();
            }
        });

    }




}
