package demo.wrc.com.project.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseActivity;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class ActivityHttp extends BaseActivity {
    private Class<BaseFragment> calss ;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_http);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initToolBar("UI篇","",R.color.colorAccent);
        initView();
    }
    
    
    @Override
    protected void initView() {
        calss = (Class<BaseFragment>) getIntent().getSerializableExtra("fragment");
        addMultipleFragments(R.id.frament_container_main_ui, calss);
    }
    
    
    /**
     * 实现按两次back键退出程序的功能
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
//        if (KeyEvent.KEYCODE_BACK == keyCode) {
//            return true;
//        }
        return super.onKeyDown(keyCode, event);
    }
    
    
    @Override
    public void initToolBar(String title, String subTitle, int titleColor) {
        if (title == null){
            title ="";
        }
        if (subTitle == null){
            subTitle = "";
        }
        if (titleColor == 0){
            titleColor = R.color.colorPrimary;
        }
        getSupportActionBar().setTitle(title);
        toolbar.setSubtitle(subTitle);
        toolbar.setTitleTextColor(titleColor);
    }
    
    
    @Override
    public Toolbar getToolBar() {
        
        return  toolbar;
    }
}
