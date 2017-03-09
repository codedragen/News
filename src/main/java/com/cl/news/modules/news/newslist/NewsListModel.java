package com.cl.news.modules.news.newslist;

import com.cl.news.MyApplication;
import com.cl.news.http.RetrofitService;
import com.cl.news.http.bean.NewsInfo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sks on 2017/3/9.
 */

public class NewsListModel {

    private final RetrofitService service;

    public NewsListModel(){
         service = new RetrofitService();
        service.init(MyApplication.getContext());
    }

    public Observable<List<NewsInfo>> getNewsList(String newstypeid, int page){
       return service.getNewsList(newstypeid,page);
    }

    
}
