package demo.wrc.com.project.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.TabLayoutViewPagerAdapter;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class UIFragment extends BaseFragment {


    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mIvBook;
    private TextView mTvTitle;
    private TextView mTvMsg;
    private TextView mTvRating;
    private TabLayout mTabLayout;
    
    private ViewPager mViewPager;
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_main_ui;
    }
    /**
     * 保存gps信息
     */
    private void dbStore() {
        
            long degree = 6;
            String degreeStr = "###.";
            for (int i = 0; i < degree; ++i) {
                degreeStr += "0";
            }
            DecimalFormat df = new DecimalFormat(degreeStr);
            String Latitude = "" + df.format(convertGps(27.82626d));
            String Longidute = "" + df.format(convertGps(121.13181d));
            
                Log.d("wrc", "GPS信息："  + Latitude +","+Longidute);
            
    }
    /**
     * 将经纬度转换成京东需要的数据（京东后台地图需要的数据与真实gps数据有偏差）
     * @param value 经纬度
     * @return
     */
    public static double convertGps(double value) {
        
        double result = 0;
        
        String[] degreeArr = Location.convert(value, Location.FORMAT_SECONDS).split(":");
        
        if (degreeArr.length == 3) {
            
            double degree = Double.parseDouble(degreeArr[0]);
            double minute = Double.parseDouble(degreeArr[1]);
            double second = Double.parseDouble(degreeArr[2]);
            
            result = degree + minute / 100 + second / 60 / 100;
        }
        return result;
    }

    @Override
    protected void initView(final View view, Bundle savedInstanceState) {

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        mIvBook = (ImageView) view.findViewById(R.id.iv_book_image);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mTvMsg = (TextView) view.findViewById(R.id.tv_msg);
        mTvRating = (TextView) view.findViewById(R.id.tv_rating);
//        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.tablayout_viewpager);
       
        
        UIFragmentOne oneFragment = new UIFragmentOne();
        UIFragmentTwo twoFragment = new UIFragmentTwo();
        UIFragmentThree threeFragment = new UIFragmentThree();
        List<BaseFragment> listFragment = new ArrayList<>();
        listFragment.add(oneFragment);
        listFragment.add(twoFragment);
        listFragment.add(threeFragment);
        mViewPager.setAdapter(new TabLayoutViewPagerAdapter(getFragmentManager(),listFragment));
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("系统自带效果");
        mTabLayout.getTabAt(1).setText("第二回");
        mTabLayout.getTabAt(2).setText("第三回");
        dbStore();
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                       mViewPager.setCurrentItem(position);
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//
//                        break;
//
//                }
//            }
//
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }


    @Override
    protected void initData() {
        mTvTitle.setText("Material Design（材质设计）是Google在2014年I/O大会上发布的一种新的设计规范。");
        mIvBook.setImageResource(R.mipmap.img_medg01);
        mIvBook.setOnClickListener(UIFragment.this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.iv_book_image:
                fragmentManager(R.id.frament_container_main,ChangeUserInfoFragment.class);
//                ToastUtil.showToast(getActivity(),"点我干嘛",0);
                break;


            default:

                break;


        }

    }
}
