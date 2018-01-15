package demo.wrc.com.project.fragment.ui_material_design;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AnimationThreeDetailFragment extends BaseFragment {
    
    private ImageView img01;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_animation_three_detail;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        initToolBar("UI篇", "AnimationThreeDetail", 0);
        img01 = (ImageView) view.findViewById(R.id.animation_second_detail_img01);
        img01.setOnClickListener(this);
    
        //----------------------Slide------------------------
//        Slide slide = new Slide();
//        slide.setDuration(300);
//        mActivity.getWindow().setExitTransition(slide);//出去的动画
//        mActivity.getWindow().setEnterTransition(slide);//进去的动画
        //----------------------------------------------
    
    
        //-----------------------Explode-----------------------
//        Explode explode = new Explode();
//        explode.setDuration(2000);
//        mActivity.getWindow().setExitTransition(explode);//
//        mActivity.getWindow().setEnterTransition(explode);//
        //----------------------------------------------
    
        //------------------------Fade----------------------
        Fade fade = new Fade();
        fade.setDuration(2000);
        mActivity.getWindow().setExitTransition(fade);//
        mActivity.getWindow().setEnterTransition(fade);//
        //----------------------------------------------
        
        
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animation_second_detail_img01:
               mActivity.finishAfterTransition();
                break;
        
        }
    }
    
    
    
}
