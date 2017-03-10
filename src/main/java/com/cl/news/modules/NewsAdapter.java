package com.cl.news.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.news.R;
import com.cl.news.http.bean.NewsInfo;

import java.util.List;

/**
 * Created by sks on 2017/3/10.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEWTYPE_HEAD = 0;
    private static final int VIEWTYPE_THREEIMG = 1;
    private static final int VIEWTYPE_NORMAL = 2;
    private final List<NewsInfo> data;

    public NewsAdapter(List<NewsInfo> data){
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View itemview;
       switch (viewType){
           case VIEWTYPE_HEAD:
                itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitem_head,parent,false);
                holder=new HeadNewsHolder(itemview);
               break;
           case VIEWTYPE_THREEIMG:
               itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitem_threeimg,parent,false);
               holder=new ThreeIMGNewsHolder(itemview);
               break;
           case VIEWTYPE_NORMAL:
               itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitem_normal,parent,false);
               holder=new NormalNewsHolder(itemview);
               break;
       }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if (holder instanceof HeadNewsHolder){
             HeadNewsHolder headNewsHolder= (HeadNewsHolder) holder;

         }else if (holder instanceof  ThreeIMGNewsHolder){
             ThreeIMGNewsHolder threeIMGNewsHolder= (ThreeIMGNewsHolder) holder;
         }else{
             NormalNewsHolder normalNewsHolder= (NormalNewsHolder) holder;

         }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return VIEWTYPE_HEAD;
        else
        return getVIewTYpe(position);


    }

    private int getVIewTYpe(int position) {
        NewsInfo info=  data.get(position);
        if (info.getImgextra()!=null)
            return VIEWTYPE_THREEIMG;
        return VIEWTYPE_NORMAL;
    }






    public class NormalNewsHolder extends RecyclerView.ViewHolder {
        public NormalNewsHolder(View itemView) {
            super(itemView);

        }
    }
    public class HeadNewsHolder extends RecyclerView.ViewHolder {
        public HeadNewsHolder(View itemView) {
            super(itemView);

        }
    }

    public class ThreeIMGNewsHolder extends RecyclerView.ViewHolder {
        public ThreeIMGNewsHolder(View itemView) {
            super(itemView);

        }
    }

}
