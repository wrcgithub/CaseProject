package demo.wrc.com.project.base;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import demo.wrc.com.project.R;
import demo.wrc.com.project.fragment.HttpFragment;
import demo.wrc.com.project.fragment.SqlitFragment;
import demo.wrc.com.project.fragment.UIFragment;
import demo.wrc.com.project.fragment.WodeFragment;
import demo.wrc.com.project.utils.ToastUtil;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    
    
    private RadioGroup radioGroup;
    private RadioButton rb_ui;
    private Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        initToolBar("Android","主界面",R.color.colorAccent);
        initView();
        
    }
    
    
    
    @Override
    protected void initView() {
        
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(MainActivity.this);
        rb_ui = (RadioButton) radioGroup.findViewById(R.id.rb_ui);
        rb_ui.setChecked(true);
    }
    
    
    /**
     * 实现按两次back键退出程序的功能
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            goBack();
            return true;
        }
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
    return toolbar;
    }
    
    
    private long mExitTime = 0;
    public static final int EXIT_TIME_GAP = 2000;
    
    
    private void goBack() {
        
        if (SystemClock.uptimeMillis() - mExitTime > EXIT_TIME_GAP) {
            ToastUtil.toast("再按一次返回键退出");
            mExitTime = SystemClock.uptimeMillis();
        } else {
            MainActivity.this.finish();
        }
    }
    
    
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        
        switch (checkedId) {
            
            case R.id.rb_ui:
                fragmentManager(R.id.frament_container_main, UIFragment.class);
                break;
            case R.id.rb_http:
                ToastUtil.toast("【网络】 -- 暂无内容");
                fragmentManager(R.id.frament_container_main,HttpFragment.class);
                break;
            case R.id.rb_sqlite:
                ToastUtil.toast("【数据库】 -- 暂无内容");
                fragmentManager(R.id.frament_container_main,SqlitFragment.class);
                break;
            case R.id.rb_wode:
                fragmentManager(R.id.frament_container_main, WodeFragment.class);
                break;
            
        }
        
    }
    
}
