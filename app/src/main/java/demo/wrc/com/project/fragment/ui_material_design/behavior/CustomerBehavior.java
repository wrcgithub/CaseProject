package demo.wrc.com.project.fragment.ui_material_design.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


/**
 * Created by wrc on 2018/1/14/014.
 */

public class CustomerBehavior extends CoordinatorLayout.Behavior<View> {
    
    public CustomerBehavior(Context context, AttributeSet attrs) {
    
        super();
    }
    
    /**
     * 用来决定需要监听哪些控件或者容器的状态（1.知道监听谁；2.什么状态改变）
     * CoordinatorLayout parent ，父容器
     * View child, 子控件---需要监听dependency这个view的视图们---观察者
     View dependency，你要监听的那个View
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //还可以根据ID或者TAG来判断
        return dependency instanceof TextView || super.layoutDependsOn(parent, child, dependency);
    }
    
    
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //获取被监听的view的状态---垂直方向位置
        int offset = dependency.getTop() - child.getTop();
        //让child进行平移
        ViewCompat.offsetTopAndBottom(child,offset);
        
        return super.onDependentViewChanged(parent, child, dependency);
    }
}