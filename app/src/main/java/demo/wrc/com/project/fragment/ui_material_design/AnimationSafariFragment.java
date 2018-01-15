package demo.wrc.com.project.fragment.ui_material_design;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AnimationSafariFragment extends BaseFragment  {
    private LinearLayout layout ;
    private ImageView imageView;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_animation_safari;
    }
    
    
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initToolBar("UI篇","AnimationSafari",0);
        layout = (LinearLayout) view.findViewById(R.id.animation_safari_first);
        imageView = (ImageView) view.findViewById(R.id.animation_safari_second);
        layout.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.animation_safari_first:
            startFirstAnimation();
            break;
        case R.id.animation_safari_second:
            startSecondAnimation();
            break;
        
    }
    }
    public void startFirstAnimation(){
    
        ObjectAnimator rotationAnimation = ObjectAnimator.ofFloat(layout,"rotationX",0f,25f);
        rotationAnimation.setDuration(300);
    
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(layout,"alpha",1f,0.5f);
        alphaAnimation.setDuration(300);
    
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(layout,"scaleX",1f,0.8f);
        scaleXAnimation.setDuration(300);
    
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(layout,"scaleY",1f,0.8f);
        scaleYAnimation.setDuration(300);
        
        ObjectAnimator scaleResumeAnimation =  ObjectAnimator.ofFloat(layout,"rotationX",25f,0f);
        scaleResumeAnimation.setDuration(100);
        scaleResumeAnimation.setStartDelay(300);//延时动画，过300毫秒的时候开始执行，
    
        ObjectAnimator translationYAnimation =  ObjectAnimator.ofFloat(layout,"translationY",0f,-0.1f*layout.getHeight());
        translationYAnimation.setDuration(300);
    
        ObjectAnimator translationYAnimationSecond =  ObjectAnimator.ofFloat(imageView,"translationY",imageView.getHeight(),0);
        translationYAnimationSecond.setDuration(300);
        translationYAnimationSecond.addListener(new AnimatorListenerAdapter() {
    
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                layout.setEnabled(false);
                imageView.setVisibility(View.VISIBLE);
            }
        });
        
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimation,alphaAnimation,scaleXAnimation,scaleYAnimation,scaleResumeAnimation,translationYAnimation,translationYAnimationSecond);
        animatorSet.start();
    
    
    }
    public void startSecondAnimation(){
    
        ObjectAnimator rotationAnimation = ObjectAnimator.ofFloat(layout,"rotationX",25f,0f);
        rotationAnimation.setDuration(300);
    
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(layout,"alpha",0.5f,1f);
        alphaAnimation.setDuration(300);
    
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(layout,"scaleX",0.8f,1f);
        scaleXAnimation.setDuration(300);
    
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(layout,"scaleY",0.8f,1f);
        scaleYAnimation.setDuration(300);
    
//        ObjectAnimator scaleResumeAnimation =  ObjectAnimator.ofFloat(layout,"rotationX",0f,25f);
//        scaleResumeAnimation.setDuration(100);
//        scaleResumeAnimation.setStartDelay(300);//延时动画，过300毫秒的时候开始执行，
    
        ObjectAnimator translationYAnimation =  ObjectAnimator.ofFloat(layout,"translationY",-0.1f*layout.getHeight(),0f);
        translationYAnimation.setDuration(300);
    
        ObjectAnimator translationYAnimationSecond =  ObjectAnimator.ofFloat(imageView,"translationY",0f,imageView.getHeight());
        translationYAnimationSecond.setDuration(300);
        translationYAnimationSecond.addListener(new AnimatorListenerAdapter() {
        
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                layout.setEnabled(true);
                imageView.setVisibility(View.GONE);
            }
        });
    
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimation,alphaAnimation,scaleXAnimation,scaleYAnimation,translationYAnimation,translationYAnimationSecond);
        animatorSet.start();
    
    
    }
}
