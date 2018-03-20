package demo.wrc.com.project.fragment.ui_material_design;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AnimationSecondFragment extends BaseFragment {
    
    private ImageView img01, img02;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_animation_second;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        initToolBar("UI篇", "AnimationSecond", 0);
        img01 = (ImageView) view.findViewById(R.id.animation_second_img01);
        img02 = (ImageView) view.findViewById(R.id.animation_second_img02);
        img01.setOnClickListener(this);
        img02.setOnClickListener(this);
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
        
        switch (v.getId()) {
            case R.id.animation_second_img01:
                startFirstAnimation();
                break;
            case R.id.animation_second_img02:
                startSecondAnimation();
                break;
            
        }
    }
    
    
    public void startFirstAnimation() {
        
        Animator animator = ViewAnimationUtils.createCircularReveal(img01, img01.getWidth() / 2, img01.getHeight() / 2, 0, img01.getHeight());
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
        
        
    }
    
    
    public void startSecondAnimation() {
        Animator animator = ViewAnimationUtils.createCircularReveal(img02, 0, 0, 0, (float) Math.hypot(img02.getWidth(),img02.getHeight()));
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    
    }
}
