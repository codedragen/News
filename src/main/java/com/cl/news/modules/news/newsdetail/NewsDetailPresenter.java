package com.cl.news.modules.news.newsdetail;

import android.text.Html;
import android.util.Log;

import com.cl.news.http.bean.NewsDetailInfo;
import com.cl.news.modules.base.BasePresenter;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.ig.DefaultImageGetter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by sks on 2017/3/15.
 */
public class NewsDetailPresenter implements BasePresenter{

    private final NewsDetailModel model;
    private final NewsDetailView view;

    public NewsDetailPresenter(NewsDetailModel model, NewsDetailView view){
        this.model=model;
        this.view=view;
        view.setPresenter(this);
    }
    @Override
    public void start() {

    }

    public void getNewsDetail(String newsid){
        model.getNewsDetail(newsid, new Observer<NewsDetailInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showLoad();
            }

            @Override
            public void onNext(NewsDetailInfo value) {
                Log.i("getNewsDetail",value.getBody());
                String body= value.getBody();
                if (value.getImg()!=null||!value.getImg().isEmpty()){
                    for (NewsDetailInfo.ImgEntity img : value.getImg()) {
                        String src=img.getSrc();
                        String ref=img.getRef();
                       body= body.replaceAll(ref,"<img src=\""+src+"\"/>");

                    }
                }
                value.setBody(body);
                view.addData(value);
            }

            @Override
            public void onError(Throwable e) {
              view.onError(e);
            }

            @Override
            public void onComplete() {
               view.onComplete();
            }
        });
    }


}
