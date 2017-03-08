package com.cl.news.modules.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by sks on 2017/3/8.
 */

public abstract class BaseFragment extends Fragment {

    boolean oncreatedView=false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        oncreatedView=true;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden&&oncreatedView)
            lazyLoad();
    }

 public abstract  void lazyLoad();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        oncreatedView=false;
    }


}
