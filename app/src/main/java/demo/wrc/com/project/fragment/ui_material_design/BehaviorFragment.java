package demo.wrc.com.project.fragment.ui_material_design;

import android.os.Bundle;
import android.view.View;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class BehaviorFragment extends BaseFragment  {
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_behavior;
    }
    
    
    @Override
    public void onResume() {
        
        super.onResume();
//        toolbar.setTitle("UI篇");
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initToolBar("UI篇","Behavior",0);
    
    }
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    
    
}
