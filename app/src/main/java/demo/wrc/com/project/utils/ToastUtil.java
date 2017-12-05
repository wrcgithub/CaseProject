package demo.wrc.com.project.utils;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import demo.wrc.com.project.R;


public class ToastUtil {
	private static final long TOAST_THRESHOLD = 2000;
	public static  final int gravity = Gravity.BOTTOM;
	public static  final int xOffset = 0;
	public static  final int yOffset = 150;
	
	private static long previous = 0;
	private static Toast toast;
	private static Context mContext;
	private static TextView messageTV;
	
	private ToastUtil() {}
	
	
	public static void init(Context context) {
		mContext = context;
	}
	
	public static void toast(String message) {
		toast(message, Toast.LENGTH_SHORT);
	}
	
	public static void toast(int id) {
		toast(id, Toast.LENGTH_SHORT);
	}
	
	public static void toast(int id, int duration) {
		String message = mContext.getString(id);
		toast(message, duration);
	}
	
	public static void toast(String message, int duration) {
		long now = System.currentTimeMillis();
		if (now - previous < TOAST_THRESHOLD) {
			messageTV.setText(message);
			toast.show();
		} else {
			if (toast != null) {
				toast.cancel();
			}
			toast = new Toast(mContext);
			LayoutInflater inflater = LayoutInflater.from(mContext);
			View view = inflater.inflate(R.layout.my_toast, null);
			 messageTV = (TextView) view.findViewById(R.id.message);
			messageTV.setText(message);
			
			toast.setGravity(gravity, xOffset, yOffset);
			if (duration == 0){
				toast.setDuration( Toast.LENGTH_SHORT);
			}else {
				toast.setDuration( Toast.LENGTH_LONG);
			}
			toast.setView(view);
			toast.show();
		}
		previous = now;
	}
	
	public static void toast(String message, int duration, int xOffset, int yOffset) {
		long now = System.currentTimeMillis();
		if (now - previous < TOAST_THRESHOLD) {
			messageTV.setText(message);
			toast.show();
		} else {
			if (toast != null) {
				toast.cancel();
			}
			toast = new Toast(mContext);
			LayoutInflater inflater = LayoutInflater.from(mContext);
			View view = inflater.inflate(R.layout.my_toast, null);
			 messageTV = (TextView) view.findViewById(R.id.message);
			messageTV.setText(message);
			
			toast.setGravity(gravity, xOffset, yOffset);
			if (duration == 0){
				toast.setDuration( Toast.LENGTH_SHORT);
			}else {
				toast.setDuration( Toast.LENGTH_LONG);
			}
			toast.setView(view);
			toast.show();
			
		}
		previous = now;
	}
	
	public static void cancel() {
		if (toast != null) {
			toast.cancel();
		}
	}
	
}
