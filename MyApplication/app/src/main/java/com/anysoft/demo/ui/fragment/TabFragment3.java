package com.anysoft.demo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anysoft.demo.R;
import com.anysoft.demo.base.BaseLazyFragment;
import com.anysoft.demo.ui.activity.MainActivity;


/**
 * Created by LiTingYao on 2018/7/28.
 */
public class TabFragment3 extends BaseLazyFragment {
    
    public static TabFragment3 getInstance() {
        return new TabFragment3();
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = View.inflate(inflater.getContext(), R.layout.fragment_tab_layout, null);
        TextView tv_tab_content = rootView.findViewById(R.id.tv_tab_content);
        tv_tab_content.setText("" + this.getClass().getSimpleName());
        tv_tab_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        return rootView;
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Log.e("lty", this.getClass().getSimpleName() + " onResume: ");
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Log.e("lty", this.getClass().getSimpleName() + " onPause: ");
    }
    
    @Override
    public void onUIVisibleChange(boolean isUIVisible) {
        Log.e("lty", this.getClass().getSimpleName() + " onUIVisibleChange: " + isUIVisible);
    }
    
    @Override
    public void initView() {
    
    }
}
