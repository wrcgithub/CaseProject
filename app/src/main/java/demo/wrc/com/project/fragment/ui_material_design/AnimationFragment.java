package demo.wrc.com.project.fragment.ui_material_design;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AnimationFragment extends BaseFragment {
    
    
    private ImageView meinv01,meinv02,meinv03,meinv04,meinv05,meinv06;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_animation;
    }
    
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        initToolBar("UI篇", "Animation", 0);
        meinv01 = (ImageView) view.findViewById(R.id.animation_meinv01);
        meinv02 = (ImageView) view.findViewById(R.id.animation_meinv02);
        meinv03 = (ImageView) view.findViewById(R.id.animation_meinv03);
        meinv04 = (ImageView) view.findViewById(R.id.animation_meinv04);
        meinv05 = (ImageView) view.findViewById(R.id.animation_meinv05);
        meinv06 = (ImageView) view.findViewById(R.id.animation_meinv06);
        meinv01.setOnClickListener(this);
        meinv02.setOnClickListener(this);
        meinv03.setOnClickListener(this);
        meinv04.setOnClickListener(this);
        meinv05.setOnClickListener(this);
        meinv06.setOnClickListener(this);
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
        
        switch (v.getId()) {
            case R.id.animation_meinv01:
                setAnimation(1, v);
                break;
            case R.id.animation_meinv02:
                setAnimation(2, v);
                break;
            case R.id.animation_meinv03:
                setAnimation(3, v);
                break;
            case R.id.animation_meinv04:
                setAnimation(4, v);
                break;
            case R.id.animation_meinv05:
                setAnimation(5, v);
                break;
            case R.id.animation_meinv06:
                setAnimation(6, v);
                break;
        }
    }
    
    
    private void setAnimation(int type, final View view) {
        
        if (type == 1) {
            
            ObjectAnimator ob1 = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f, 1f);
            ob1.setDuration(5000);
            ob1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //动画在执行过程中，不断调用此方法
//                    animation.getAnimatedFraction();//整个动画执行了的百分比，100%说明动画执行完毕
                    
                    //得到durations时间内values当中的某个中间值，0f~200f
                    float value = (float) animation.getAnimatedValue();
                    view.setAlpha(value / 200);
//                    view.setScaleX(value/200);
//                    view.setScaleY(value/200);
                    
                }
            });
            ob1.start();
        } else if (type == 2) {
            ObjectAnimator animator01 = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.2f, 1f);
            ObjectAnimator animator02 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.2f, 1f);
            ObjectAnimator animator03 = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.2f, 1f);
            ObjectAnimator animator04 = ObjectAnimator.ofFloat(view, "rotation", 0f, -360f, 0f);
            
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(3000);
            animatorSet.playTogether(animator01, animator02, animator03, animator04);
            animatorSet.start();
            
        } else if (type == 3) {
            
            PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0.2f, 1f);
            PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.2f, 1f);
            PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.2f, 1f);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, holder1, holder2, holder3);
            animator.setDuration(3000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //动画在执行过程中，不断调用此方法
//                    animation.getAnimatedFraction();//整个动画执行了的百分比，100%说明动画执行完毕
                    
                    //得到durations时间内values当中的某个中间值，0f~200f
                    float value = (float) animation.getAnimatedValue();
                    view.setAlpha(value / 200);
//                    view.setScaleX(value/200);
//                    view.setScaleY(value/200);
                
                }
            });
            animator.start();
            
            
        }else if (type == 4) {
            /**
             * x:匀速
             * y:加速度 y=1/2*g*t*t
             * 使用估值器比较好实现
             */
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(3000);
//            valueAnimator.setObjectValues(values);
            valueAnimator.setObjectValues(new PointF(0,0));
            
            //估值器
            valueAnimator.setEvaluator(new TypeEvaluator() {
    
                @Override
                public Object evaluate(float fraction, Object startValue, Object endValue) {
                    /**
                     * fraction:百分比
                     * startValue:
                     * endValue:
                     */
                    //去拿到每一个时间的坐标
                    //x = v*t (s秒)
                    PointF pointF = new PointF();
                    pointF.x = 100f*(fraction*4);//速度*执行的百分比*4，值的大小自己看着定义
                    pointF.y = 0.5f*98f*(fraction*4)*(fraction*4);// y:加速度 y=1/2*g*t*t
                    
                    return pointF;
                }
            });
            final float startX = view.getX();
            final float startY = view.getY();
            
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //得到此时间点的坐标
                PointF pointF= (PointF) animation.getAnimatedValue();
                    view.setX(startX+pointF.x);
                    view.setY(startY+pointF.y);
                    
                }
            });
            //设置加速器，
            valueAnimator.start();
            
            
            
        }
        if (type == 5){
            ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationY",0f,200f);
            animator.setDuration(3000);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.start();
        }
        if (type == 6){
            ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationY",0f,200f);
            animator.setDuration(3000);
            if (ret == 0){
                animator.setInterpolator(new AccelerateInterpolator(5));
            }else if (ret == 1){
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            else if (ret == 2){
                animator.setInterpolator(new AnticipateInterpolator(8));
            }
            else if (ret == 3){
                animator.setInterpolator(new OvershootInterpolator());
            }
            else if (ret == 4){
                animator.setInterpolator(new CycleInterpolator(4));
            }
            else if (ret == 5){
                animator.setInterpolator(new BounceInterpolator());
            }
            else if (ret == 6){
    
            }
            else if (ret == 7){
    
            }
            else if (ret == 8){
    
            }
            ++ ret ;
            animator.start();
            if (ret == 6){
                ret = 0;
            }
        }
    }
    int ret = 0;
}
