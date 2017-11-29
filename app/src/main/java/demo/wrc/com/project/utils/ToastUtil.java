package demo.wrc.com.project.utils;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import demo.wrc.com.project.R;


public class ToastUtil {

	/**
	 *
	 * @param context  上下文
	 * @param message  要吐司的消息内容
	 * @param duration  0：显示时间短； 其他数值：显示时间长
     */
	public static void showToast(Context context, String message,int duration) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.my_toast, null);
		TextView messageTV = (TextView) view.findViewById(R.id.message);
		messageTV.setText(message);

		Toast toast = new Toast(context);
		toast.setGravity(Gravity.TOP, 0, 420);
		if (duration == 0){
			toast.setDuration( Toast.LENGTH_SHORT);
		}else {
			toast.setDuration( Toast.LENGTH_LONG);
		}
		toast.setView(view);
		toast.show();
	}
}
