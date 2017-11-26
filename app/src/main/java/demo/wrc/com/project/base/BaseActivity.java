package demo.wrc.com.project.base;


import android.app.Activity;
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

import demo.wrc.com.project.utils.MyToast;
import demo.wrc.com.project.utils.TitleBar;


public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
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

	protected void init() {

	}




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


	@Override
	public void onClick(View v) {

			onClickView(v.getId());
	}
	protected  void onClickView(int id){}

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

	public  void showShortToast(String message){

		MyToast.showToast(this,message,Toast.LENGTH_SHORT);

	}
	public  void showLongToast(String message){

		MyToast.showToast(this,message,Toast.LENGTH_LONG);

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
}
