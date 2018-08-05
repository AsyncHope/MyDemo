package com.anysoft.demo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 懒加载的fargment
 */

public abstract class BaseLazyFragment extends Fragment {
    
    private boolean isViewCreated;
    private boolean isUIVisible;
    public View rootView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getUserVisibleHint() && !isViewCreated) {
            initView();
            isUIVisible = true;
            onUIVisibleChange(true);
        }
    }
    
    
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null) {
            return;
        }
        
        if (isVisibleToUser) {
            isUIVisible = true;
            onUIVisibleChange(true);
            return;
        }
        
        if (isUIVisible) {
            onUIVisibleChange(false);
            isUIVisible = false;
        }
    }
    
    private void initVariable() {
        isUIVisible = false;
        isViewCreated = false;
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        initVariable();
    }
    
    public abstract void onUIVisibleChange(boolean isUIVisible);
    
    public abstract void initView();
    
}
