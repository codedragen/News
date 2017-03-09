package com.cl.news.modules.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.news.R;
import com.cl.news.modules.base.BaseFragment;
import com.cl.news.modules.base.BasePagerFragment;
import com.cl.news.modules.base.BasePresenter;

/**
 * Created by sks on 2017/3/7.
 */

public class NewsFragment extends BaseFragment implements NewsView {

    String TAG=getClass().getSimpleName();
    private NewsPresenter presenter;

    public static NewsFragment getInstance(){
        return new NewsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          Log.i(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_news,container,false);

    }



    @Override
    public void lazyLoad() {
        presenter.start();

    }

    @Override
    public void setPresenter(NewsPresenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showLoading() {

    }
}
