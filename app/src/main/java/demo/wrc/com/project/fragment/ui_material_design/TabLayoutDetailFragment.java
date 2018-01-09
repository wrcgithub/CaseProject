package demo.wrc.com.project.fragment.ui_material_design;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/9/009.
 */

public class TabLayoutDetailFragment extends BaseFragment{
    
    @Override
    protected int getLayoutId() {
        
        return 0;
    }
    
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        tv.setBackgroundColor(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
        tv.setText(title);
        return tv;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initTitle("TabLayoutDetail");
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}
