package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.RecyclerViewUIoneWaterfallsAdapter;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class UIFragmentOne extends BaseFragment {
    
    
    private RecyclerView mRecyclerView;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_main_ui_one;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_ui_one);
        
        
    }
    
    
    @Override
    protected void initData() {
//        //listView 样式
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                getActivity(), LinearLayoutManager.HORIZONTAL, 3, getResources().getColor(R.color.gray_01)));

//         //同上 listView 样式
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                getActivity(),  LinearLayoutManager.HORIZONTAL, R.drawable.divider_bg));
    
        final StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                getActivity(),  LinearLayoutManager.HORIZONTAL, R.drawable.divider_bg));
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
    
    
        mRecyclerView.setAdapter(new RecyclerViewUIoneWaterfallsAdapter(UIFragmentOne.this, testData()));
        
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
    
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        
                super.onScrollStateChanged(recyclerView, newState);
//                staggeredGridLayoutManager.invalidateSpanAssignments();//避免上下滑动时出现错位
            }
        });
        
    }
    protected List<String> testData() {
        
        List<String> mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++){
            mDatas.add("" + (char) i);
        }
        return mDatas;
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}
