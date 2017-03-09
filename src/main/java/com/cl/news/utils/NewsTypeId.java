package com.cl.news.utils;

import android.content.Context;
import android.util.Log;

import com.cl.news.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/**
 * Created by sks on 2017/3/9.
 */

public class NewsTypeId {

    public  static final Map<String,String> NEWSTYPE=new HashMap<>();

    public static Map<String,String> getNewsType(Context context){
        Log.i("getNewsType","getNewsType");
        InputStream inputStream =context.getResources().openRawResource(R.raw.newstypeid);
        Source source= Okio.source(inputStream);
        BufferedSource buffer = Okio.buffer(source);
        String readed;
        StringBuilder sb=new StringBuilder();
        try {
                readed=buffer.readUtf8();
                sb.append(readed);
            JSONArray jsonArray=new JSONArray(sb.toString());
            Log.i("getNewsType",jsonArray.length()+"========Length");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject o = (JSONObject) jsonArray.get(i);
                Log.i("getNewsType",o.getString("name"));
                NEWSTYPE.put( o.getString("name"),o.getString("typeId"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("IOException",e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("JSONException",e.getMessage());
        }

        return NEWSTYPE;

    }




}
