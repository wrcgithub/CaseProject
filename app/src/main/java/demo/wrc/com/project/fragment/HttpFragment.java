package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.view.View;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.TranslucentListener;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class HttpFragment extends BaseFragment implements TranslucentListener{
    
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_main_http;
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
    
    
    @Override
    public void onTranlucent(float alpha) {
    }
}
