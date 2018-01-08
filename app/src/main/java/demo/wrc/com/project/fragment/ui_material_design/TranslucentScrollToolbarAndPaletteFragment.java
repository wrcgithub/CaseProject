package demo.wrc.com.project.fragment.ui_material_design;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.TranslucentListener;
import demo.wrc.com.project.view.MyScrollView;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class TranslucentScrollToolbarAndPaletteFragment extends BaseFragment implements TranslucentListener{
    private TextView toolbar,textView00,textView01;
    private MyScrollView scrollView;
    private ImageView imageView;
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_translucentscrolltoolbar_palette;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        toolbar = (TextView) view.findViewById(R.id.main_http_toolbar);
        scrollView = (MyScrollView) view.findViewById(R.id.main_http_scrollview);
        scrollView.setTranslucentListener(this);
        imageView = (ImageView) view.findViewById(R.id.imageview01);
        textView00 = (TextView) view.findViewById(R.id.textView0);
        textView01 = (TextView) view.findViewById(R.id.textView1);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        //得到Bitmap里面的一些色彩信息，通过Palette分析出来（里面有用到非常多的算法）
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
        
            @Override
            public void onGenerated(Palette palette) {
                //暗、柔和的颜色
                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);//如果分析不出来，则返回默认颜色
                //暗、柔和
                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
                //暗、鲜艳
                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
                //亮、鲜艳
                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
                //柔和
                int mutedColor = palette.getMutedColor(Color.BLUE);
                //柔和
                int vibrantColor = palette.getVibrantColor(Color.BLUE);
                //获取某种特性颜色的样品
//				Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
                Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();
                //谷歌推荐的：图片的整体的颜色rgb的混合值---主色调
                int rgb = lightVibrantSwatch.getRgb();
                //谷歌推荐：图片中间的文字颜色
                int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
                //谷歌推荐：作为标题的颜色（有一定的和图片的对比度的颜色值）
                int titleTextColor = lightVibrantSwatch.getTitleTextColor();
                //颜色向量
                float[] hsl = lightVibrantSwatch.getHsl();
                //分析该颜色在图片中所占的像素多少值
                int population = lightVibrantSwatch.getPopulation();
                textView01.setBackgroundColor(getTranslucentColor(0.6f,rgb));
                textView01.setTextColor(titleTextColor);
                textView00.setBackgroundColor(bodyTextColor);
            
            }
        });
    
    }
    /**
     * 1101 0111 1000 1011
     * 			 1111 1111
     * 			 1000 1011
     */
    protected int getTranslucentColor(float percent, int rgb) {
        // 10101011110001111
        int blue = Color.blue(rgb);
        int green = Color.green(rgb);
        int red = Color.red(rgb);
        int alpha = Color.alpha(rgb);
//		int blue = rgb & 0xff;
//		int green = rgb>>8 & 0xff;
//		int red = rgb>>16 & 0xff;
//		int alpha = rgb>>>24;
        
        alpha = Math.round(alpha*percent);
        return Color.argb(alpha, red, green, blue);
    }
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    
    
    @Override
    public void onTranlucent(float alpha) {
        toolbar.setAlpha(alpha);
    }
}
