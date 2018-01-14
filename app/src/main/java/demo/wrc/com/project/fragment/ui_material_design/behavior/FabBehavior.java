package demo.wrc.com.project.fragment.ui_material_design.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by wrc on 2018/1/13/013.
 */

public class FabBehavior extends FloatingActionButton.Behavior {
    
    private boolean visible = true;//是否可见
    
    FabBehavior(Context context, AttributeSet attrs){
        super();
    }
    
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        //当观察的View（RecyclerView）发送滑动的开始时候回调的，nestedScrollAxes:滑动关联轴，我们现在只关系垂直的滑动
        return nestedScrollAxes == ViewGroup.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }
    
    
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        //当观察的View滑动的时候回调的，根据情况执行动画
        //dyConsumed > 0  表示Y轴方向滑动的距离大于20（API定的值）
        if (dyConsumed > 0 && visible) {
            //show
            onHide(child);
            visible = false;
        } else if (dyConsumed < 0 && !visible) {
            //hide
            onShow(child);
            visible = true;
        }
    }
        public void onHide(FloatingActionButton fab) {
            // 隐藏动画--属性动画
//		toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
            ViewGroup.MarginLayoutParams layoutParams = ( ViewGroup.MarginLayoutParams) fab.getLayoutParams();

//		fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
            ViewCompat.animate(fab).scaleX(0f).scaleY(0f).start();
        }
    
        public void onShow(FloatingActionButton fab) {
            // 显示动画--属性动画
//		toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    
            ViewGroup.MarginLayoutParams layoutParams = ( ViewGroup.MarginLayoutParams) fab.getLayoutParams();
//		fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
            ViewCompat.animate(fab).scaleX(1f).scaleY(1f).start();
        }
    
    
}
