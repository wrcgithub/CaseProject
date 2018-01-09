package demo.wrc.com.project.fragment.ui_material_design;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.FragmentPagerAdapter;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class TableLayoutFragment extends BaseFragment {
    private TabLayout tabLayout;
    private String[] title = {
		"头条",
		"新闻",
		"娱乐",
		"体育",
		"科技",
		"美女",
            "财经",
            "汽车",
            "房子",
            "头条"
    };
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_tablelayout;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initTitle("TabLayout");
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp);
        tabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());
        //1.TabLayout和Viewpager关联
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			@Override
			public void onTabUnselected(TabLayout.Tab arg0) {
			}

			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				// 被选中的时候回调
				viewPager.setCurrentItem(tab.getPosition(),true);
			}

			@Override
			public void onTabReselected(TabLayout.Tab arg0) {
			}
		});
		//2.ViewPager滑动关联tabLayout
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//		//设置tabLayout的标签来自于PagerAdapter
		tabLayout.setTabsFromPagerAdapter(adapter);
    
        viewPager.setAdapter(adapter);
        //方法二：一步到位
//        tabLayout.setupWithViewPager(viewPager);
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    
    class MyPagerAdapter extends FragmentPagerAdapter{
        
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
        
        @Override
        public Fragment getItem(int position) {
            Fragment f = new TabLayoutDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title[position]);
            f.setArguments(bundle);
            return f;
        }
        
        @Override
        public int getCount() {
            return title.length;
        }
        
    }
}
