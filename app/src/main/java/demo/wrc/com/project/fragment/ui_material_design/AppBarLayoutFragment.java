package demo.wrc.com.project.fragment.ui_material_design;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.RecyclerViewWaterfallsAdapter;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.model.TestInfo;
import demo.wrc.com.project.recycler.RecycleViewDivider;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class AppBarLayoutFragment extends BaseFragment {
    
    private RecyclerView mRecyclerView;
    private List<TestInfo> listTest;
    private RecyclerViewWaterfallsAdapter adapter;
    private Toolbar childToolBar;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_ui_appbar_layout;
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        
        toolbar.setVisibility(View.GONE);
        childToolBar = (Toolbar) view.findViewById(R.id.child_toolbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_ui_one);
    }
    
    
    @Override
    public void onResume() {
        
        super.onResume();
        childToolBar.setTitle("UI篇");
        childToolBar.setSubtitle("AppBarLayout");
    }
    
    
    @Override
    protected void initData() {
        
        testData();
        adapter = new RecyclerViewWaterfallsAdapter(AppBarLayoutFragment.this, listTest);
        //listView 样式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, 3, getResources().getColor(R.color.gray_01)));
        
        
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
                
                
                ToastUtil.toast("长按了： " + listTest.get(position).getName());
                return  true;
            }
        }).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
                
                ToastUtil.toast("点击了： " + listTest.get(position).getName());
            }
        });
        
        
    }
    
    
    protected List<TestInfo> testData() {
        
        listTest = new ArrayList<TestInfo>();
        for (int i = 'A'; i < 'z'; i++){
            TestInfo info = new TestInfo();
            info.setName("" + (char) i);
            info.setTrue(false);
            listTest.add(info);
        }
        return listTest;
    }
    
    
    @Override
    public void onClick(View v) {
        
    }
    
    
}
