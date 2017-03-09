package com.cl.news.modules.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.cl.news.R;

import com.cl.news.modules.news.NewsFragment;
import com.cl.news.modules.news.NewsModel;
import com.cl.news.modules.news.NewsPresenter;
import com.cl.news.modules.photo.PhotoFragment;
import com.cl.news.modules.video.VideoFragment;


public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private BottomNavigationView bottomNavigationView;

    private NewsFragment newsFragment;
    private VideoFragment videoFragment;
    private PhotoFragment photoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer= (DrawerLayout) findViewById(R.id.activity_main_drawer);
        navigationView= (NavigationView) findViewById(R.id.activity_main_navigationview);
        ViewGroup.LayoutParams layoutParams = navigationView.getLayoutParams();
        layoutParams.width=getResources().getDisplayMetrics().widthPixels/2;
        navigationView.setLayoutParams(layoutParams);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.activity_main_navigation);
           if (savedInstanceState==null){
               newsFragment= NewsFragment.getInstance();
               videoFragment= VideoFragment.getInstance();
               photoFragment = PhotoFragment.getInstance();
               getSupportFragmentManager().beginTransaction().add(R.id.activity_main_container,newsFragment,"news").add(R.id.activity_main_container,photoFragment,"photo").add(R.id.activity_main_container,videoFragment,"video").hide(photoFragment).hide(videoFragment).show(newsFragment).commit();
           }else{
              newsFragment= (NewsFragment) getSupportFragmentManager().findFragmentByTag("news");
              photoFragment= (PhotoFragment) getSupportFragmentManager().findFragmentByTag("photo");
              videoFragment= (VideoFragment) getSupportFragmentManager().findFragmentByTag("video");
           }
            new NewsPresenter(newsFragment,new NewsModel());
            initListener();



    }


    private void initListener(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.news:
                        switchFragment(newsFragment);
                        break;
                    case R.id.video:
                        switchFragment(videoFragment);
                        break;
                    case R.id.photo:
                        switchFragment(photoFragment);
                        break;
                    case R.id.download:
                        break;

                }
                return true;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return true;
            }
        });


    }

    private void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().hide(newsFragment).hide(photoFragment).hide(videoFragment).commit();
        getSupportFragmentManager().beginTransaction().show(fragment).commit();


    }

}
