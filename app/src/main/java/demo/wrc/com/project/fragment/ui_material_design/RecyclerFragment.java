package demo.wrc.com.project.fragment.ui_material_design;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.adapter.RecyclerViewWaterfallsAdapter;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.OnClickDialogChoice;
import demo.wrc.com.project.fragment.ui_material_design.listener.HideScrollListener;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.model.TestInfo;
import demo.wrc.com.project.popup.DialogCustomUtil;
import demo.wrc.com.project.recycler.RecycleViewDivider;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class RecyclerFragment extends BaseFragment implements HideScrollListener{
        
        
        private RecyclerView mRecyclerView;
        
        private List<TestInfo> listTest;
        private RecyclerViewWaterfallsAdapter adapter;
    private Toolbar childToolBar;
    private FloatingActionButton fab;
        
        @Override
        protected int getLayoutId() {
        
        return R.layout.fragment_ui_recycler;
    }
        
        
        @Override
        protected void initView(View view, Bundle savedInstanceState) {
//        initToolBar("UI篇","Recycler",0);
            toolbar.setVisibility(View.GONE);
            childToolBar = (Toolbar) view.findViewById(R.id.child_toolbar);
            fab = (FloatingActionButton) view.findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_ui_one);
//        mRecyclerView.addOnScrollListener(new FabScrollListener(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    @Override
    public void onResume() {
        
        super.onResume();
        childToolBar.setTitle("UI篇");
        childToolBar.setSubtitle("RecyclerView");
    }
        
        @Override
        protected void initData() {
        testData();
        adapter = new RecyclerViewWaterfallsAdapter(RecyclerFragment.this, listTest);
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
    
    
    @Override
    public void onHide() {
//        // 隐藏动画--属性动画
//        childToolBar.animate().translationY(-childToolBar.getHeight()).setInterpolator(new AccelerateInterpolator(1));
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fab.getLayoutParams();
//
//        fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(1));
    }
    
    
    @Override
    public void onShow() {
//        // 显示动画--属性动画
//        childToolBar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(1));
//
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fab.getLayoutParams();
//        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(1));
    }
}
