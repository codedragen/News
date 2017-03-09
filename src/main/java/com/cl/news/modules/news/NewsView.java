package com.cl.news.modules.news;

import android.support.v4.app.Fragment;

import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BaseView;

import java.util.List;

/**
 * Created by sks on 2017/3/8.
 */
public interface NewsView extends BaseView<NewsPresenter>{

 void initData(List<Fragment> fragments,List<String> titles);


}
