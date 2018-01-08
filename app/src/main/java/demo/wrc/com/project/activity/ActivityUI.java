package demo.wrc.com.project.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseActivity;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class ActivityUI extends BaseActivity {
    private Class<BaseFragment> calss ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        initTitle("功能详情界面");
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
}
