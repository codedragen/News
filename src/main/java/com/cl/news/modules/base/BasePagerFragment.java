package com.cl.news.modules.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;




public abstract class BasePagerFragment extends Fragment {

     private boolean isViewCreated=false;
    private boolean isLoaded=false;

    String TAG=getClass().getSimpleName();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onViewCreated");
        isViewCreated=true;
        if (!isLoaded&&getUserVisibleHint()){
            isLoaded=true;
            lazyLoad();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG,"setUserVisibleHint");
        if (isVisibleToUser&&isViewCreated&&!isLoaded){
            isLoaded=true;
            lazyLoad();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated=false;
        isLoaded=false;
        Log.i(TAG,"onDestroyView");
    }



    public abstract  void lazyLoad();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.i(TAG,"onAttachFragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");

    }





    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach");

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(TAG,"onHiddenChanged"+hidden);
    }
}
