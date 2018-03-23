package demo.wrc.com.project.fragment.sqlite;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class OriginalDBFragment extends BaseFragment {
    
    private TextView textView00, textView01;
    private ScrollView scrollView;
    private ImageView imageView;
    private Toolbar childToolBar;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_http_okhttp_getpost;
    }
    
    
    @Override
    public void onResume() {
        
        super.onResume();
//        childToolBar.setTitle("HTTP篇");
        initToolBar("数据库", "OriginalDB", 0);
//        childToolBar.setTitleTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
//        initToolBar("UI篇","Translucent_Palette",0);
        toolbar.setVisibility(View.GONE);
        childToolBar = (Toolbar) view.findViewById(R.id.child_toolbar);
        scrollView = (ScrollView) view.findViewById(R.id.main_http_scrollview);
        imageView = (ImageView) view.findViewById(R.id.imageview01);
        textView00 = (TextView) view.findViewById(R.id.textView0);
        textView01 = (TextView) view.findViewById(R.id.textView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            
            @Override
            public boolean onLongClick(View v) {
                
                return false;
            }
        });
        
    }
    
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    
}
