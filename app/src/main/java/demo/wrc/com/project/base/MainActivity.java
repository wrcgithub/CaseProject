package demo.wrc.com.project.base;

import android.os.Bundle;

import demo.wrc.com.project.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitle("首页导航");
    }
}
