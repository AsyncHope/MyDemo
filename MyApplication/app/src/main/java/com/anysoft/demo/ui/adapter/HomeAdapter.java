package com.anysoft.demo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anysoft.demo.base.BaseLazyFragment;

import java.util.List;

/**
 * Created by LiTingYao on 2018/7/28.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    List<BaseLazyFragment> mData;
    public HomeAdapter(FragmentManager fm, List<BaseLazyFragment> fragments) {
        super(fm);
        mData = fragments;
    }
    
    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }
    
    @Override
    public int getCount() {
        return mData.size();
    }
    
}
