package demo.wrc.com.project.base;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import demo.wrc.com.project.R;
import demo.wrc.com.project.fragment.UIFragment;
import demo.wrc.com.project.fragment.WodeFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup radioGroup;
    private RadioButton rbUI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle("首页导航");
//        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
//        radioGroup.setOnCheckedChangeListener(MainActivity.this);
        initView();
    }


    @Override
    protected void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(MainActivity.this);
//        rbUI = (RadioButton) findViewById(R.id.rb_ui);
//        rbUI.setOnClickListener(this);

    }


    @Override
    protected void initData() {
//        rbUI.performClick();
    }


    @Override
    public void onClick(View v) {
        onClickView(v.getId());
    }


    @Override
    protected void onClickView(int id) {

        switch (id) {


        }
    }
    /**
     * 实现按两次back键退出程序的功能
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
    private long mExitTime = 0;
    public static final int EXIT_TIME_GAP = 2000;
    private void goBack() {
        if (SystemClock.uptimeMillis() - mExitTime > EXIT_TIME_GAP) {
            Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
            mExitTime = SystemClock.uptimeMillis();
        } else {
            MainActivity.this.finish();
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case R.id.rb_ui:
                fragmentManager(R.id.frament_container_main,UIFragment.class);
                break;
            case R.id.rb_http:
                fragmentManager(R.id.frament_container_main,UIFragment.class);
                break;
            case R.id.rb_sqlite:
                fragmentManager(R.id.frament_container_main,WodeFragment.class);
                break;
            case R.id.rb_wode:
                fragmentManager(R.id.frament_container_main,WodeFragment.class);
                break;

        }

    }
}
