package com.anysoft.demo.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;

import com.anysoft.demo.R;
import com.anysoft.demo.base.BaseActivity;
import com.anysoft.demo.base.BaseLazyFragment;
import com.anysoft.demo.ui.adapter.HomeAdapter;
import com.anysoft.demo.ui.fragment.TabFragment1;
import com.anysoft.demo.ui.fragment.TabFragment2;
import com.anysoft.demo.ui.fragment.TabFragment3;
import com.anysoft.demo.widget.BottomNavigationViewEx;
import com.anysoft.demo.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by LiTingYao on 2018/7/28.
 */
public class HomeActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    
    @BindView(R.id.home_viewpager)
    NoScrollViewPager home_viewpager;
    @BindView(R.id.home_navigation_view)
    BottomNavigationViewEx home_navigation_view;
    private ArrayList<BaseLazyFragment> mFragments;
    private TabFragment1 tab1;
    private TabFragment2 tab2;
    private TabFragment3 tab3;
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("lty", this.getClass().getSimpleName() + " onResume: ");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("lty", this.getClass().getSimpleName() + " onPause: ");
    }
    
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_home_layout;
    }
    
    @Override
    public void initView() {
        super.initView();
        home_navigation_view.enableAnimation(false);
        home_navigation_view.enableItemShiftingMode(false);
        home_navigation_view.enableShiftingMode(false);
        home_navigation_view.setOnNavigationItemSelectedListener(this);
        
    }
    
    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        tab1 = TabFragment1.getInstance();
        tab2 = TabFragment2.getInstance();
        tab3 = TabFragment3.getInstance();
        mFragments.add(tab1);
        mFragments.add(tab2);
        mFragments.add(tab3);
        MenuItem homeItem = home_navigation_view.getMenu().getItem(0);
        homeItem.setTitle("tab1");
        homeItem.setChecked(true);
        MenuItem childItem = home_navigation_view.getMenu().getItem(1);
        childItem.setTitle("tab2");
        MenuItem settingItem = home_navigation_view.getMenu().getItem(2);
        settingItem.setTitle("tab3");
        HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(),mFragments);
        home_viewpager.setAdapter(adapter);
        home_viewpager.setCurrentItem(0,false);
        home_viewpager.setOffscreenPageLimit(0);
        home_viewpager.setOnPageChangeListener(this);
    }
    
    @Override
    public void initListener() {
        home_navigation_view.setOnNavigationItemSelectedListener(this);
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_home:
                home_viewpager.setCurrentItem(0,false);
                break;
            case R.id.tab_parent:
                home_viewpager.setCurrentItem(1,false);
                break;
            case R.id.tab_forward:
                home_viewpager.setCurrentItem(2,false);
                break;
        }
        return true;
    }
    
    
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    
    }
    
    @Override
    public void onPageSelected(int position) {
        home_navigation_view.getMenu().getItem(position).setChecked(true);
    }
    
    @Override
    public void onPageScrollStateChanged(int state) {
    
    }
}
