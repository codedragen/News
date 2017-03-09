package com.cl.news.modules.news;

import com.cl.news.http.NewsApi;
import com.cl.news.http.RetrofitService;
import com.cl.news.http.bean.NewsInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

/**
 * Created by sks on 2017/3/8.
 */

public class NewsModel {

    private final RetrofitService api;

   public  NewsModel(RetrofitService api){
        this.api=api;
    }


    public void getNewsList(String newsId, int page, final Observer<NewsInfo> observer){
        api.getNewsList(newsId, page).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {

            }
        }).subscribe(new Observer<NewsInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                  observer.onSubscribe(d);
            }

            @Override
            public void onNext(NewsInfo value) {
                   observer.onNext(value);
            }

            @Override
            public void onError(Throwable e) {
                observer.onError(e);
            }

            @Override
            public void onComplete() {
                    observer.onComplete();
            }
        });
    }



}
