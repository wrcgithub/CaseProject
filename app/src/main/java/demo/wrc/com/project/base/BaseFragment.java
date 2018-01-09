package demo.wrc.com.project.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 全局Fragment的基类
 * Created by wrc on 2017/11/26/026.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected Activity mActivity;

    /**
     * 获得全局 防止使用getActivity()为空
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity())
                .inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
    
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
       
    }

    /**
     * 该抽象方法：onCreateView中需要的layoutID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 该抽象方法：初始化view
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 执行加载数据
     */
    protected abstract void initData();
    
    /**
     * 设置Title
     */
    protected  void initTitle(String title){
        BaseActivity baseActivity = (BaseActivity ) getActivity();
        baseActivity.initTitle(title);
    }


    /**
     * 静态工厂方法
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T extends BaseFragment> T getInstance(Class<T> tClass){
        T t = null;
        try {
            t = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    /**
     * 获得当前fragment对象的tag值
     * @return
     */
    public String getFTag(){
        return "" + this.hashCode();
    }


    /**
     * 主界面fragment管理方法
     */
    public void fragmentManager(int fl_resid, Class fclass){
        Activity activity = getActivity();
        if(activity instanceof BaseActivity){
            BaseActivity baseActivity = (BaseActivity) activity;
            baseActivity.fragmentManager(fl_resid, fclass);
        }
    }
    /**
     * fragment管理方法
     */
    public void addMultipleFragments(int fl_resid, Class fclass){
        Activity activity = getActivity();
        if(activity instanceof BaseActivity){
            BaseActivity baseActivity = (BaseActivity) activity;
            baseActivity.fragmentManager(fl_resid, fclass);
        }
    }
}
