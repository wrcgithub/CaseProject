package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import demo.wrc.com.project.R;
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
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_main_ui;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        mIvBook = (ImageView) view.findViewById(R.id.iv_book_image);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mTvMsg = (TextView) view.findViewById(R.id.tv_msg);
        mTvRating = (TextView) view.findViewById(R.id.tv_rating);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("第一回"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第二回"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三回"));

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
