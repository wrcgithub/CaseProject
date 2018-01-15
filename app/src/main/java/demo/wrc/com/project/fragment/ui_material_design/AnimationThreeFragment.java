package demo.wrc.com.project.fragment.ui_material_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.activity.ActivityUI;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AnimationThreeFragment extends BaseFragment {
    
    private ImageView img01;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_animation_three;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        initToolBar("UI篇", "AnimationThree", 0);
        img01 = (ImageView) view.findViewById(R.id.animation_second_img01);
        img01.setOnClickListener(this);
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
            
        }
    }
    
    
    public void startFirstAnimation() {
        //共享元素，动画
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,img01,"image01");
//
//        Intent intent = new Intent(mActivity, ActivityUI.class);
//        intent.putExtra("fragment",AnimationThreeDetailFragment.class);
//        startActivity(intent,optionsCompat.toBundle());
 
        
        //----------------------Slide(滑动效果)------------------------
//        Slide slide = new Slide();
//        slide.setDuration(300);
//        mActivity.getWindow().setExitTransition(slide);//出去的动画
//        mActivity.getWindow().setEnterTransition(slide);//进去的动画
        //----------------------------------------------
        
        
        //-----------------------Explode(展开效果)-----------------------
//        Explode explode = new Explode();
//        explode.setDuration(2000);
//        mActivity.getWindow().setExitTransition(explode);//
//        mActivity.getWindow().setEnterTransition(explode);//
        //----------------------------------------------
    
        
        //------------------------Fade(渐变隐藏效果)----------------------
        Fade fade = new Fade();
        fade.setDuration(2000);
        mActivity.getWindow().setExitTransition(fade);//
        mActivity.getWindow().setEnterTransition(fade);//
        //----------------------------------------------
    
        //以上效果都不加，则只有下面的效果---共享元素，转场动画
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,img01,"image01");
        Intent intent = new Intent(mActivity, ActivityUI.class);
        intent.putExtra("fragment",AnimationThreeDetailFragment.class);
        startActivity(intent,optionsCompat.toBundle());
    
    
    }
    
}
