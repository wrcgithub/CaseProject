package demo.wrc.com.project.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

import demo.wrc.com.project.utils.Files;
import demo.wrc.com.project.utils.ToastUtil;


public class BaseApplication extends Application {
    
    private static BaseApplication instance;
    private List<AppCompatActivity> mList = new LinkedList<AppCompatActivity>();
    private boolean isInited = false;
    
    
    @SuppressLint("NewApi")
    public void onCreate() {
        
        super.onCreate();
        CrashHandler.getInstance().init(this);
        Thread.setDefaultUncaughtExceptionHandler(CrashHandler.getInstance());
        initApplication();
        
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
    
    
    public void addActivity(AppCompatActivity activity) {
        
        if (mList.size() > 8) {
            mList.get(0).finish();
            mList.remove(0);
        }
        mList.add(activity);
    }
    
    
    public void removeActiviy(AppCompatActivity activity) {
        
        mList.remove(activity);
    }
    
    
    public void exit() {
        
        try {
            for (AppCompatActivity activity : mList){
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
    
    
    private void initApplication() {
        
        if (!isInited) {
            
            ToastUtil.init(this);
            
            
            isInited = true;
        }
        
        
    }
    public AppCompatActivity getTopActivity() {
        
       int size = mList.size();
        if (mList.isEmpty()) {
            return null;
        }
        int index = mList.size() - 1;
        return mList.get(index);
    
    }
    
    public void exitApplication(int exitCode) {
        
        exit();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(exitCode);
        
    }
}