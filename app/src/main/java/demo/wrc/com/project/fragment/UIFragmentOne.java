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
import demo.wrc.com.project.callback.OnClickDialogChoice;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.popup.CustomDialogUtil;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class UIFragmentOne extends BaseFragment {
    
    
    private RecyclerView mRecyclerView;
    
    private  List<String> mDatas;
    private RecyclerViewUIoneWaterfallsAdapter adapter;
    
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
        testData();
        adapter = new RecyclerViewUIoneWaterfallsAdapter(UIFragmentOne.this, mDatas);
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
    
    
        mRecyclerView.setAdapter(adapter);
        
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
    
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        
                super.onScrollStateChanged(recyclerView, newState);
//                staggeredGridLayoutManager.invalidateSpanAssignments();//避免上下滑动时出现错位
            }
        });
        ItemClickSupport.addTo(mRecyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
    
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, final int position, View v) {
    
                CustomDialogUtil.showDialogChoice(getActivity(), true, "是否删除" + mDatas.get(position), new OnClickDialogChoice() {
    
                    @Override
                    public void confirm(boolean flag, String msg) {
                        adapter.removeData(position);
                    }
    
    
                    @Override
                    public void cancel(String errMsg) {
        
                    }
                });
                return false;
            }
        }).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
    
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
                CustomDialogUtil.showDialogChoice(getActivity(), true, "是否添加 AA" + mDatas.get(position), new OnClickDialogChoice() {
        
                    @Override
                    public void confirm(boolean flag, String msg) {
                        adapter.addItem(position,"AA"+position);
                    }
        
        
                    @Override
                    public void cancel(String errMsg) {
            
                    }
                });
            }
        });
        
        
        
    }
    
    
    protected List<String> testData() {
        
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++){
            mDatas.add("" + (char) i);
        }
        return mDatas;
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}
