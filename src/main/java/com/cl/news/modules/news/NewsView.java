package com.cl.news.modules.news;

import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BaseView;

/**
 * Created by sks on 2017/3/8.
 */
public interface NewsView extends BaseView<NewsPresenter>{

    public void showLoading();

    void addData(NewsInfo value);

    void showError(Throwable e);

    void loadComplete();

}
