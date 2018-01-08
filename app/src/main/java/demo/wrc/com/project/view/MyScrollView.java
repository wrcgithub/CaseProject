package demo.wrc.com.project.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import demo.wrc.com.project.callback.TranslucentListener;


/**
 * Created by wrc on 2018/1/7/007.
 */

public class MyScrollView extends ScrollView {
    
    private TranslucentListener listener;
    
    public void setTranslucentListener(TranslucentListener listener){
        
        this.listener = listener;
    }
    
    
    
    public MyScrollView(Context context) {
        
        super(context);
    }
    
    
    public MyScrollView(Context context, AttributeSet attrs) {
        
        super(context, attrs);
    }
    
    
    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        
        super(context, attrs, defStyleAttr);
    }
    
    
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        
        super.onScrollChanged(l, t, oldl, oldt);
        int scrollY = getScrollY();//代表ScrollView划出去的高度
        int screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;//拿到屏幕的高度
        if(scrollY <= screenHeight/3f){
            listener.onTranlucent(1-scrollY/(screenHeight/3f));//alpha=划出去的的高度/(屏幕的高度/3f)
        }
   
   
   
    }
}
