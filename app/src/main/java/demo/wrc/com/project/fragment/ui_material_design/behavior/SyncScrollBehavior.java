package demo.wrc.com.project.fragment.ui_material_design.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by wrc on 2018/1/14/014.
 */

public class SyncScrollBehavior extends CoordinatorLayout.Behavior<View> {
    
    public SyncScrollBehavior(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    
    
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }
    
    
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        int scrollY = target.getScrollY();
        child.setScrollY(scrollY);
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }
    
    
    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        
        //快速滑动的惯性移动（即松开手后仍会有滑动）
        ((NestedScrollView)child).fling((int)velocityY);
        
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
