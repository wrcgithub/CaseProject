package demo.wrc.com.project.base;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import demo.wrc.com.project.R;
import demo.wrc.com.project.utils.TitleBar;
import demo.wrc.com.project.utils.ToastUtil;


public class BaseActivity extends AppCompatActivity {
    
    
    private FragmentManager fragmentManager;
    private Map<String, String> fragmentMap = new HashMap<>();
    private BaseFragment showFragment;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
//		initView();
//		initData();
        getSupportActionBar().hide();
        fragmentManager = getFragmentManager();
        fullScreen(this);
        BaseApplication.getInstance().addActivity(this);
        
    }
    
    
    @Override
    protected void onDestroy() {
        
        BaseApplication.getInstance().removeActiviy(this);
        super.onDestroy();
    }
    
    
    public boolean onback() {
        
        return false;
    }
    
    
    /**
     * 初始化布局ID
     */
    protected void initView() {
    
    }
    
    
    ;
    
    
    /**
     * 初始化数据
     */
    protected void initData() {
    
    }
    
    
    ;
    
    
    @Override
    protected void onResume() {
        
        super.onResume();
    }
    
    
    public void showMessage(String message) {
        
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    
    
    public void showErroMessage(String message) {
        
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//			return onback();
//		}
        
        return super.onKeyDown(keyCode, event);
    }
    
    
    /**
     * 1.设置左边的图片按钮显示，以及事件
     * 2.设置中间TextView显示的文字
     * 3.设置右边的图片按钮显示，并设置事件
     */
    protected void initTitle(String title) {
        
        new TitleBar(this).setMiddleTitleText(title);
        
    }
    
    
    public static void setHintTextSize(EditText editText, String hintText, int textSize) {
        // 新建一个可以添加属性的文本对象
        SpannableString ss = new SpannableString(hintText);
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(textSize, true);
        // 附加属性到文本
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        
        // 设置hint
        editText.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失
    }
    
    
    public void showShortToast(String message) {
        
        ToastUtil.toast(message);
        
    }
    
    
    public void showLongToast(String message) {
        
        ToastUtil.toast(message);
        
    }
    
    
    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }
    
    
    /**
     * 带默认过程动画的启动Activity方式
     *
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        
        this.startActivity(intent, R.anim.activity_in_rigth, R.anim.activity_out);
    }
    
    
    /**
     * 自定义过场动画的Activity启动方式
     *
     * @param intent
     * @param animin
     * @param animout
     */
    public void startActivity(Intent intent, int animin, int animout) {
        
        super.startActivity(intent);
        overridePendingTransition(animin, animout);
    }
    
    
    /**
     * fragment管理 -- 不包含过程动画的方式
     */
    public void fragmentManager(int fl_resid, Class fclass) {
        
        fragmentManager(fl_resid, 0, 0, fclass);
    }
    
    
    /**
     * 包含动画的fragment管理
     *
     * @param fl_resid 给fragment占位的布局id
     * @param fclass   fragment进入的动画
     * @param inanim   fragment退出的动画
     * @param outanim  需要显示的fragment的Class对象
     */
    public void fragmentManager(int fl_resid, int inanim, int outanim, Class<BaseFragment> fclass) {
        
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (inanim != 0 || outanim != 0) {
            fragmentTransaction.setCustomAnimations(inanim, outanim);
        }
        if (fragmentMap.containsKey(fclass.getName())) {
            BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentMap.get(fclass.getName()));
            if (showFragment != null && fragment.getClass() != showFragment.getClass()) {
                fragmentTransaction.hide(showFragment);
            }
            fragmentTransaction.show(fragment);
            showFragment = fragment;
        } else {
            BaseFragment baseFragment = BaseFragment.getInstance(fclass);
            fragmentTransaction.add(fl_resid, baseFragment, baseFragment.getFTag());
            fragmentMap.put(fclass.getName(), baseFragment.getFTag());
            
            if (showFragment != null && baseFragment.getClass() != showFragment.getClass()) {
                fragmentTransaction.hide(showFragment);
            }
            showFragment = baseFragment;
        }
        fragmentTransaction.commit();
    }
    
    /**
     * fragment管理 -- 不包含过程动画的方式
     */
    public void addMultipleFragments(int fl_resid, Class fclass) {
        
        fragmentManager(fl_resid, 0, 0, fclass);
    }
    /**
     * 包含动画的fragment管理
     *
     * @param fl_resid 给fragment占位的布局id
     * @param fclass   fragment进入的动画
     * @param inanim   fragment退出的动画
     * @param outanim  需要显示的fragment的Class对象
     */
    public void addMultipleFragments(int fl_resid, int inanim, int outanim, Class<BaseFragment> fclass) {
        
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (inanim != 0 || outanim != 0) {
            fragmentTransaction.setCustomAnimations(inanim, outanim);
        }
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentMap.get(fclass.getName()));
        fragmentTransaction.replace(fl_resid, fragment);
//		fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
}
