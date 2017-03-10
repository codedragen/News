package com.cl.news.modules.news.newslist;

import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BaseView;

import java.util.List;

/**
 * Created by sks on 2017/3/9.
 */

public interface NewsListView extends BaseView<NewsListPresenter> {

    void showLoading();

    void addData(List<NewsInfo> value);

    void onError(Throwable e);

    void loadComplete();
}
