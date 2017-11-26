package demo.wrc.com.project.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import demo.wrc.com.project.utils.Files;


public class BaseApplication extends Application {
	private static BaseApplication instance;
	private List<Activity> mList = new LinkedList<Activity>();

	@SuppressLint("NewApi")
	public void onCreate() {
		super.onCreate();
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());
		try {
			Files.createFile(getApplicationContext());
//			TmsDealManage.initDealManage(this);// 初始化
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	public synchronized static BaseApplication getInstance() {
		if (null == instance) {
			instance = new BaseApplication();
		}
		return instance;
	}


	public void addActivity(Activity activity) {
		if (mList.size() > 8) {
			mList.get(0).finish();
			mList.remove(0);
		}
		mList.add(activity);
	}

	public void removeActiviy(Activity activity) {
		mList.remove(activity);
	}

	public void exit() {
		try {
			for (Activity activity : mList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}

}