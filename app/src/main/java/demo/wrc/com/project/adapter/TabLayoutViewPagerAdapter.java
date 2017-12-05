package demo.wrc.com.project.adapter;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.List;

import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2017/12/5/005.
 */

public class TabLayoutViewPagerAdapter extends FragmentPagerAdapter {
    
    private List<BaseFragment> listFragment ;
    
    public TabLayoutViewPagerAdapter(FragmentManager fm,List<BaseFragment> listFragment ){
        super(fm);
        this.listFragment = listFragment;
        
    }
    
    @Override
    public Fragment getItem(int position) {
        
        return listFragment.get(position);
    }
    
    
    @Override
    public int getCount() {
        
        return listFragment.size();
    }
    
    
    
    
}
