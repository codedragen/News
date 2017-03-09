package com.cl.news.modules.news;

import android.app.FragmentManagerNonConfig;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.cl.news.MyApplication;
import com.cl.news.http.NewsApi;
import com.cl.news.http.RetrofitService;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.news.newslist.NewsListFragment;
import com.cl.news.modules.news.newslist.NewsListModel;
import com.cl.news.modules.news.newslist.NewsListPresenter;
import com.cl.news.utils.NewsTypeId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

/**
 * Created by sks on 2017/3/8.
 */

public class NewsModel {


    public void initData(NewsModel.CallBack callBack){
        Map<String,String> newsType=  NewsTypeId.getNewsType(MyApplication.getContext());
        Set<Map.Entry<String, String>> entries = newsType.entrySet();

        List<String>titles = new ArrayList<>();

        List<Fragment>fragments = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            titles.add(entry.getKey());
            NewsListFragment instance = NewsListFragment.getInstance(entry.getValue());
            new NewsListPresenter(new NewsListModel(),instance);
            fragments.add(instance);

        }
        callBack.onDataInit(fragments,titles);


    }

    interface CallBack{
        void onDataInit(List<Fragment> fragments,List<String> titles);
    }
}
