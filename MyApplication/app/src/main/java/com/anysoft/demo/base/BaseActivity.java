package com.anysoft.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.anysoft.demo.MyApplication;
import com.zhy.autolayout.AutoLayoutActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by LiTingYao on 2018/6/16.
 */
public abstract class BaseActivity extends AutoLayoutActivity {
    
    public MyApplication myApplication;
    private Unbinder unbinder;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        //子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()
        myApplication = (MyApplication) this.getApplication();
        setContentView(provideContentViewId());
        unbinder = ButterKnife.bind(this);
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
        }
        initView();
        initData();
        initListener();
    }
    
    /**
     * 在布局之前做的一些操作
     */
    protected void doBeforeSetContentView() {
    
    }
    
    /**
     * 当前界面的布局文件id(由子类实现)
     * @return
     */
    protected abstract int provideContentViewId();
    /**
     * 初始化view
     */
    public void initView() {
    }
    /**
     * 初始化数据
     */
    public void initData() {
    }
    /**
     * 初始化监听器
     */
    public void initListener() {
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
    
    /*为了做点击外部区域隐藏键盘 start*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }
    /*为了做点击外部区域隐藏键盘 end*/
}
