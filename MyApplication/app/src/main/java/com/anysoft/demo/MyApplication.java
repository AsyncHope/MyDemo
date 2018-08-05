package com.anysoft.demo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by LiTingYao on 2018/8/4.
 */
public class MyApplication extends Application {
    public static Context context;
    
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        initThreeLib();
    }
    
    private void initThreeLib() {
    
    }
}
