package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        mTabLayout.getTabAt(0).setText("第一回");
        mTabLayout.getTabAt(1).setText("第二回");
        mTabLayout.getTabAt(2).setText("第三回");
        
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
