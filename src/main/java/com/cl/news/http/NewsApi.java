package com.cl.news.http;

import com.cl.news.http.bean.BeautyPhotoInfo;
import com.cl.news.http.bean.NewsDetailInfo;
import com.cl.news.http.bean.NewsInfo;
import com.cl.news.http.bean.PhotoInfo;
import com.cl.news.http.bean.PhotoSetInfo;
import com.cl.news.http.bean.SpecialInfo;
import com.cl.news.http.bean.VideoInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sks on 2017/3/7.
 */

public  interface NewsApi {
    /**
     * 获取新闻列表
     * eg: http://c.m.163.com/nc/article/headline/T1348647909107/60-20.html
     * http://c.m.163.com/nc/article/list/T1348647909107/60-20.html
     *
     * @param type      新闻类型
     * @param id        新闻ID
     * @param startPage 起始页码
     * @return
     */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsInfo>>> getNewsList(@Path("type") String type, @Path("id") String id, @Path("startPage") int startPage);

    /**
     * 获取专题
     * eg: http://c.3g.163.com/nc/special/S1451880983492.html
     *
     * @param specialid 专题ID
     * @return
     */
    @GET("nc/special/{specialid}")
    Observable<Map<String, SpecialInfo>> getSpecial(@Path("specailid") String specialid);

    /**
     * 获取新闻详情
     * eg: http://c.3g.163.com/nc/article/BV56RVG600011229/full.html
     *
     * @param newsid 专题ID
     * @return
     */
    @GET("nc/article/{newsid}/full.html")
    Observable<Map<String, NewsDetailInfo>> getNewsDetail(@Path("newsid") String newsid);

    /**
     * 获取新闻详情
     * eg: http://c.3g.163.com/photo/api/set/0006/2136404.json
     *
     * @param photpid 图集ID
     * @return
     */
    @GET("photo/api/set/{photoid}.json")
    Observable<PhotoSetInfo> getPhotoSet(@Path("photoid") String photpid);


    /**
     * 获取图片列表
     * eg: http://c.3g.163.com/photo/api/list/0096/4GJ60096.json
     *
     * @return
     */

    @GET("photo/api/list/0096/4GJ60096.json")
    Observable<List<PhotoInfo>> getPhotoList();

    /**
     * 获取更多图片列表
     * eg: http://c.3g.163.com/photo/api/morelist/0096/4GJ60096/106571.json
     *
     * @return
     */

    @GET("photo/api/morelist/0096/4GJ60096/{setId}.json")
    Observable<List<PhotoInfo>> getPhotoMoreList(@Path("setId") String setId);

    /**
     * 获取美女图片，这个API不完整，省略了好多参数
     * eg: http://c.3g.163.com/recommend/getChanListNews?channel=T1456112189138&size=20&offset=0
     *
     * @param offset 起始页码
     * @return
     */

    @GET("recommend/getChanListNews?channel=T1456112189138&size=20")
    Observable<Map<String, List<BeautyPhotoInfo>>> getBeautyPhoto(@Query("offset") int offset);

    /**
     * 获取视频列表
     * eg: http://c.3g.163.com/nc/video/list/V9LG4B3A0/n/10-10.html
     *
     * @param id        video ID
     * @param startPage 起始页码
     * @return
     */

    @GET("nc/video/list/{id}/n/{startPage}-10.html")
    Observable<Map<String, List<VideoInfo>>> getVideoList(@Path("id") String id,
                                                          @Path("startPage") int startPage);
}