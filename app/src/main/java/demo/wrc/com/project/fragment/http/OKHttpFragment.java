package demo.wrc.com.project.fragment.http;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.wrc.com.project.R;
import demo.wrc.com.project.activity.ActivityHttp;
import demo.wrc.com.project.adapter.RecyclerViewUIoneAdapter;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.TranslucentListener;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.recycler.RecycleViewDivider;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class OKHttpFragment extends BaseFragment implements TranslucentListener{
    private Toolbar childToolBar;
    private RecyclerView mRecyclerView;
    
    private List<Map<String ,Class>> listTest;
    private RecyclerViewUIoneAdapter adapter;
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_http_okhttp;
    }
    
    
    @Override
    public void onResume() {
        
        super.onResume();
        childToolBar.setTitle("HTTP篇");
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_http_okhttp);
//        initToolBar("UI篇","Translucent_Palette",0);
        toolbar.setVisibility(View.GONE);
        childToolBar = (Toolbar) view.findViewById(R.id.child_toolbar);
    
        testData();
        adapter = new RecyclerViewUIoneAdapter(OKHttpFragment.this, listTest);
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
            
            
                ToastUtil.toast("选中的Item："+listTest.get(position).keySet().toString());
                return false;
            }
        }).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
        
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
                //activity之间转场动画，适用于Android5.0及以上
//                mActivity.overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);//左进右出
                mActivity.overridePendingTransition(android.R.anim.cycle_interpolator,android.R.anim.cycle_interpolator);
                Intent intent = new Intent(getActivity(), ActivityHttp.class);
                intent.putExtra("fragment",listTest.get(position).get(listTest.get(position).keySet().toString().replace("[","").replace("]","")));
                startActivity(intent);
//                addMultipleFragments(R.id.frament_container_main,listTest.get(position).get(listTest.get(position).keySet().toString().replace("[","").replace("]","")));
            }
        });
    
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    
    
    @Override
    public void onTranlucent(float alpha) {
        childToolBar.setAlpha(alpha);
    }
    
    protected List<Map<String ,Class>> testData() {
        
        listTest = new ArrayList<Map<String ,Class>>();
        Map<String ,Class> map1  = new HashMap<>();
        map1.put("RecyclerView",OKHttpGetPostFragment.class);
        listTest.add(map1);
        
        return listTest;
    }
}
