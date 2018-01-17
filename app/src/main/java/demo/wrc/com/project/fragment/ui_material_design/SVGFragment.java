package demo.wrc.com.project.fragment.ui_material_design;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class SVGFragment extends BaseFragment {
    private ImageView iv2;
    private boolean isAnimation = true;
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_svg;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        initToolBar("UI篇", "SVG", 0);
         iv2 = (ImageView) view.findViewById(R.id.ui_svg_img03);
         iv2.setOnClickListener(this);
      
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            
            case  R.id.ui_svg_img03:
                Drawable drawable = iv2.getDrawable();
                if (isAnimation) {
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).start();
                    }
                    isAnimation = false;
                }else {
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).stop();
                    }
                    isAnimation = true;
                }
                break;
            
        }
    }
    
    
}
