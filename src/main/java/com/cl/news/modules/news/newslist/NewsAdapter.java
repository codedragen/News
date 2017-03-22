package com.cl.news.modules.news.newslist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cl.news.R;
import com.cl.news.http.bean.BannerInfo;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.modules.news.newsdetail.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 2017/3/10.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEWTYPE_HEAD = 0;
    private static final int VIEWTYPE_THREEIMG = 1;
    private static final int VIEWTYPE_NORMAL = 2;
    private final List<NewsInfo> data;
    private final Context context;

    public NewsAdapter(List<NewsInfo> data, Context context){
        this.data=data;this.context=context;
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
       final NewsInfo info= data.get(position);
         if (holder instanceof HeadNewsHolder){
             HeadNewsHolder headNewsHolder= (HeadNewsHolder) holder;
             List<BannerInfo> bannerInfos=new ArrayList<>();
             BannerInfo bannerinfo=new BannerInfo();
            bannerinfo.setTitle(info.getTitle());
             bannerinfo.setImgurl(info.getImgsrc());
             bannerInfos.add(bannerinfo);
             BannerAdapter adapter=new BannerAdapter(bannerInfos,context);
             headNewsHolder.pager.setAdapter(adapter);

         }else if (holder instanceof  ThreeIMGNewsHolder){
             ThreeIMGNewsHolder threeIMGNewsHolder= (ThreeIMGNewsHolder) holder;
             Glide.with(context).load(info.getImgsrc()).placeholder(R.mipmap.ic_launcher).crossFade().into(threeIMGNewsHolder.iv1);
            if (info.getImgextra()!=null&&info.getImgextra().get(0)!=null)
             Glide.with(context).load(info.getImgextra().get(0).getImgsrc()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).crossFade().into(threeIMGNewsHolder.iv2);
             if (info.getImgextra()!=null&&info.getImgextra().get(1)!=null)
             Glide.with(context).load(info.getImgextra().get(1).getImgsrc()).placeholder(R.mipmap.ic_launcher).crossFade().into(threeIMGNewsHolder.iv3);
             threeIMGNewsHolder.tv_reply.setText(info.getReplyCount()+"");
             threeIMGNewsHolder.tv_source.setText(info.getSource());
             threeIMGNewsHolder.tv_title.setText(info.getTitle());

         }else{
             NormalNewsHolder normalNewsHolder= (NormalNewsHolder) holder;
             if(info.getImgsrc()!=null)
             Glide.with(context).load(info.getImgsrc()).placeholder(R.mipmap.ic_launcher).crossFade().into(normalNewsHolder.iv);
             normalNewsHolder.tv_title.setText(info.getTitle());
             normalNewsHolder.tv_reply.setText(info.getReplyCount()+"");
             normalNewsHolder.tv_source.setText(info.getSource());
             normalNewsHolder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent=new Intent(context, NewsDetailActivity.class);
                     if (!TextUtils.isEmpty(info.getPostid())) {
                         intent.putExtra("newsId", info.getPostid());
                         context.startActivity(intent);
                     }
                 }
             });

         }
    }

    @Override
    public int getItemCount() {
        return data.size();
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
        private final ImageView iv;
        private final TextView tv_reply;
        private final TextView tv_source;
        private final TextView tv_title;

        public NormalNewsHolder(View itemView) {
            super(itemView);
             iv=(ImageView) itemView.findViewById(R.id.newslist_item_normal_iv);
             tv_reply=(TextView) itemView.findViewById(R.id.newslist_item_normal_reply);
             tv_source = (TextView) itemView.findViewById(R.id.newslist_item_normal_source);
             tv_title=(TextView)itemView.findViewById(R.id.newslist_item_normal_titile);

        }
    }
    public class HeadNewsHolder extends RecyclerView.ViewHolder {
        private final ViewPager pager;

        public HeadNewsHolder(View itemView) {
            super(itemView);
            pager=(ViewPager)itemView.findViewById(R.id.newslist_item_head_pager);


        }
    }

    public class ThreeIMGNewsHolder extends RecyclerView.ViewHolder {
        private final TextView tv_reply;
        private final TextView tv_source;
        private final ImageView iv1;
        private final ImageView iv2;
        private final ImageView iv3;
        private final TextView tv_title;

        public ThreeIMGNewsHolder(View itemView) {
            super(itemView);
            tv_source= (TextView) itemView.findViewById(R.id.newslist_item_threeimg_source);
            iv1= (ImageView) itemView.findViewById(R.id.newslist_item_threeimg_iv1);
            iv2= (ImageView)itemView.findViewById(R.id.newslist_item_threeimg_iv2);
            iv3= (ImageView)itemView.findViewById(R.id.newslist_item_threeimg_iv3);
            tv_title= (TextView) itemView.findViewById(R.id.newslist_item_threeimg_title);
            tv_reply= (TextView) itemView.findViewById(R.id.newslist_item_threeimg_reply);


        }
    }

}
