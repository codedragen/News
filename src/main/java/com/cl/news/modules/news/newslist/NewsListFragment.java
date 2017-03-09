package com.cl.news.modules.news.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cl.news.R;
import com.cl.news.modules.base.BasePagerFragment;

/**
 * Created by sks on 2017/3/9.
 */

public class NewsListFragment extends BasePagerFragment implements NewsListView{


    private View mLayout;
    private NewsListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mLayout=inflater.inflate(R.layout.fragment_newslist,container,false);

        return mLayout;
    }

    @Override
    public void lazyLoad() {


    }

    public static NewsListFragment getInstance(String newsTypeId) {
        NewsListFragment instance = new NewsListFragment();
        Bundle bundle=new Bundle();
        bundle.putString("newsTypeId",newsTypeId);
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    public void setPresenter(NewsListPresenter presenter) {
        this.presenter=presenter;
    }
}
