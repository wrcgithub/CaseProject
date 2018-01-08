package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.RecyclerViewUIoneWaterfallsAdapter;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.OnClickDialogChoice;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.model.TestInfo;
import demo.wrc.com.project.popup.DialogCustomUtil;
import demo.wrc.com.project.recycler.RecycleViewDivider;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class UIFragmentOne extends BaseFragment {
    
    
    private RecyclerView mRecyclerView;
    
    private  List<TestInfo> listTest;
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
        adapter = new RecyclerViewUIoneWaterfallsAdapter(UIFragmentOne.this, listTest);
        //listView 样式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, 3, getResources().getColor(R.color.gray_01)));

//         //同上 listView 样式
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                getActivity(),  LinearLayoutManager.HORIZONTAL, R.drawable.divider_bg));
    
//        //瀑布流
//        final StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        
        
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
    
                DialogCustomUtil.showDialogChoice(getActivity(), true, "查看选中的Item" + listTest.get(position).getName(), new OnClickDialogChoice() {
    
                    @Override
                    public void confirm(boolean flag, String msg) {
    
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < listTest.size(); i++){
                            if (listTest.get(i).isTrue()){
                                sb.append(listTest.get(i).getName()+" ");
                            }
                        }
                        
                        
                        
                        
                        ToastUtil.toast("选中的Item："+sb.toString());
//                        adapter.removeData(position);//删除所选项
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
                DialogCustomUtil.showDialogChoice(getActivity(), true, "是否添加 AA" + listTest.get(position).getName(), new OnClickDialogChoice() {
        
                    @Override
                    public void confirm(boolean flag, String msg) {
//                        adapter.addItem(position,"AA"+position);//添加一个Item
                    }
        
        
                    @Override
                    public void cancel(String errMsg) {
            
                    }
                });
            }
        });
        
        
        
    }
    
    
    protected List<TestInfo> testData() {
    
        listTest = new ArrayList<TestInfo>();
        for (int i = 'A'; i < 'z'; i++){
            TestInfo info = new TestInfo();
            info.setName(""+(char)i);
            info.setTrue(false);
            listTest.add(info);
        }
        return listTest;
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}
