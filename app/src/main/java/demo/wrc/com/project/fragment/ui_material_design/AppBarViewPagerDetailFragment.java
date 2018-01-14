package demo.wrc.com.project.fragment.ui_material_design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/9/009.
 */

public class AppBarViewPagerDetailFragment extends BaseFragment{
    
    @Override
    protected int getLayoutId() {
        
        return 0;
    }
    
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ui_appbar_viewpager_detail,container,false);
        return view;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}
