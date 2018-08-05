package com.anysoft.demo.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by LiTingYao on 2018/8/4.
 */
public class NoScrollViewPager extends ViewPager {
    
    private boolean DISABLE=false;
    
    public NoScrollViewPager(Context context){
        
        super(context);
        
    }
    
    public NoScrollViewPager(Context context, AttributeSet attrs){
        
        super(context,attrs);
        
    }
    
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return DISABLE&&super.onInterceptTouchEvent(arg0);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return DISABLE&&super.onTouchEvent(arg0);
    }
    
}
