package com.cl.news.modules.news.newslist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cl.news.R;
import com.cl.news.http.bean.BannerInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */

public class BannerAdapter extends PagerAdapter {
    private final Context context;
    private final List<BannerInfo> bannerInfos;
    private final  List<View> views;

    public BannerAdapter(List<BannerInfo> bannerInfos, Context context){
        this.bannerInfos=bannerInfos;
        this.context=context;
        this.views=new ArrayList<>();
        for (int i=0;i<bannerInfos.size();i++) {
            View itemview = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            views.add(itemview);
        }

    }
    @Override
    public int getCount() {
        return bannerInfos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=views.get(position);
        container.addView(view);
        TextView tv_title= (TextView) view.findViewById(R.id.banner_item_title);
        ImageView iv= (ImageView) view.findViewById(R.id.banner_item_iv);
       tv_title.setText(bannerInfos.get(position).getTitle());
        Glide.with(context).load(bannerInfos.get(position).getImgurl()).crossFade().placeholder(R.mipmap.ic_launcher).into(iv);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    class BannerViewHolder{
        private final TextView banner_title;
        private final ImageView banner_iv;

        BannerViewHolder(View itemview){
            banner_iv=(ImageView)itemview.findViewById(R.id.banner_item_iv);
            banner_title=(TextView)itemview.findViewById(R.id.banner_item_title);
        }
    }
}
