package com.cl.news.modules.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cl.news.R;
import com.cl.news.modules.base.BaseFragment;
import com.cl.news.modules.base.BasePagerFragment;

/**
 * Created by sks on 2017/3/7.
 */

public class VideoPagerFragment extends BaseFragment {
    String TAG=getClass().getSimpleName();
    public static VideoPagerFragment getInstance(){
        return new VideoPagerFragment();
    }
    @Override
    public void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_video,container,false);
    }
}
