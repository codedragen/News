package com.cl.news.modules.news.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.R.attr.data;

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
    private Set<NewsInfo> set=new HashSet<>();
    private NewsAdapter adapter;
  private List<NewsInfo> data;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
       recyclerView.addItemDecoration(new RecyclerItemDecoration());
         data=new ArrayList<>();
        adapter=new NewsAdapter(data,getActivity());
        recyclerView.setAdapter(adapter);
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
         set.addAll(value);
         data.clear();
         data.addAll(0,set);
         adapter.notifyDataSetChanged();

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
