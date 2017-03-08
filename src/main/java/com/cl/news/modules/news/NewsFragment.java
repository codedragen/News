package com.cl.news.modules.news;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.news.R;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BaseFragment;
import com.cl.news.modules.base.BasePagerFragment;
import com.cl.news.modules.base.BasePresenter;

/**
 * Created by sks on 2017/3/7.
 */

public class NewsFragment extends BaseFragment implements NewsView {

    String TAG=getClass().getSimpleName();
    private NewsPresenter presenter;
    private View mLayout;
    private TabLayout tab;
    private ViewPager pager;

    public static NewsFragment getInstance(){
        return new NewsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          Log.i(TAG,"onCreateView");
        mLayout=inflater.inflate(R.layout.fragment_news,container,false);
        pager= (ViewPager) mLayout.findViewById(R.id.fragment_news_pager);
         tab= (TabLayout) mLayout.findViewById(R.id.fragment_news_tab);
        tab.addTab(tab.newTab().setText("推荐"));
        tab.addTab(tab.newTab().setText("娱乐"));
        tab.addTab(tab.newTab().setText("热点"));
        tab.addTab(tab.newTab().setText("体育"));
        tab.addTab(tab.newTab().setText("北京"));
        tab.addTab(tab.newTab().setText("财经"));
        tab.addTab(tab.newTab().setText("科技"));
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setTabTextColors(Color.GRAY,Color.RED);
        tab.setSelectedTabIndicatorColor(Color.RED);
        return mLayout;

    }



    @Override
    public void lazyLoad() {
       // presenter.start();

    }

    @Override
    public void setPresenter(NewsPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void addData(NewsInfo value) {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void loadComplete() {

    }
}
