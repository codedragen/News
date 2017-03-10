package com.cl.news.modules.news.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cl.news.MyApplication;
import com.cl.news.R;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.base.BasePagerFragment;

import java.util.List;

/**
 * Created by sks on 2017/3/9.
 */

public class NewsListFragment extends BasePagerFragment implements NewsListView, SwipeRefreshLayout.OnRefreshListener {


    private View mLayout;
    private NewsListPresenter presenter;
    private String newsTypeId;
    private SwipeRefreshLayout refresh;
    private RecyclerView recyclerView;
    private int page;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mLayout=inflater.inflate(R.layout.fragment_newslist,container,false);
         String newsTypeId=  getArguments().getString("newsTypeId");
        setNewsTypeId(newsTypeId);
        return mLayout;
    }



    @Override
    public void lazyLoad() {
        initView();
        presenter.getNewsList(getNewsTypeId(),page);

    }

    private void initView() {
         recyclerView= (RecyclerView) mLayout.findViewById(R.id.fragment_newslist_recycler);
         refresh = (SwipeRefreshLayout) mLayout.findViewById(R.id.fragment_newslist_refresh);
        refresh.setOnRefreshListener(this);
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


    public String getNewsTypeId() {
        return newsTypeId;
    }


    public void setNewsTypeId(String newsTypeId) {
        this.newsTypeId=newsTypeId;
    }

    @Override
    public void showLoading() {
        refresh.setRefreshing(true);
    }

    @Override
    public void addData(List<NewsInfo> value) {
        Log.i("NewsListFragment",value.get(0).toString());
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(MyApplication.getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
       refresh.setRefreshing(false);
    }

    @Override
    public void loadComplete() {
          refresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        presenter.getNewsList(newsTypeId,page++);
    }
}
