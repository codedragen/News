package com.cl.news.modules.news;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.news.R;

import com.cl.news.http.bean.NewsInfo;

import com.cl.news.modules.base.BaseFragment;

import com.cl.news.modules.news.newslist.NewsListFragment;
import com.cl.news.utils.NewsTypeId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by sks on 2017/3/7.
 */

public class NewsFragment extends BaseFragment implements NewsView {

    String TAG=getClass().getSimpleName();
    private NewsPresenter presenter;

    private View mLayout;
    private TabLayout tab;
    private ViewPager pager;
    private Map<String, String> newsType;
    private NewsPagerAdapter adapter;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;


    public static NewsFragment getInstance(){
        return new NewsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayout=inflater.inflate(R.layout.fragment_news,container,false);
        return mLayout;
    }



    @Override
    public void lazyLoad() {
         initView();
        presenter.start();


    }

    void initView(){
        pager= (ViewPager) mLayout.findViewById(R.id.fragment_news_pager);
        tab= (TabLayout) mLayout.findViewById(R.id.fragment_news_tab);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setTabTextColors(Color.GRAY,Color.RED);
        tab.setSelectedTabIndicatorColor(Color.RED);
    }
    @Override
    public void initData(List<Fragment> fragments, List<String> titles){
        adapter=new NewsPagerAdapter(getChildFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
    }


    @Override
    public void setPresenter(NewsPresenter presenter) {
        this.presenter=presenter;
    }






    class NewsPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> fragments;
        private final List<String> titles;

        public NewsPagerAdapter(FragmentManager fm, List<Fragment> fragments,List<String> titles) {
            super(fm);
            this.fragments=fragments;
            this.titles=titles;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
