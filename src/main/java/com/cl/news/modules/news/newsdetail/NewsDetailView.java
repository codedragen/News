package com.cl.news.modules.news.newsdetail;

import com.cl.news.http.bean.NewsDetailInfo;
import com.cl.news.modules.base.BaseView;

/**
 * Created by sks on 2017/3/15.
 */

public interface NewsDetailView extends BaseView<NewsDetailPresenter> {
    void showLoad();

    void addData(NewsDetailInfo value);

    void onError(Throwable e);

    void onComplete();

}
