package com.cl.news.modules.photo;

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

public class PhotoPagerFragment extends BaseFragment {
    String TAG=getClass().getSimpleName();
    public static PhotoPagerFragment getInstance(){
        return new PhotoPagerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_photo,container,false);
    }

    @Override
    public void lazyLoad() {

    }
}
