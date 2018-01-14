package demo.wrc.com.project.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.wrc.com.project.R;
import demo.wrc.com.project.activity.ActivityUI;
import demo.wrc.com.project.adapter.RecyclerViewUIoneAdapter;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.fragment.ui_material_design.AnimationFragment;
import demo.wrc.com.project.fragment.ui_material_design.AppBarLayoutFragment;
import demo.wrc.com.project.fragment.ui_material_design.AppBarViewPagerFragment;
import demo.wrc.com.project.fragment.ui_material_design.BehaviorFragment;
import demo.wrc.com.project.fragment.ui_material_design.CollapsingToolbarLayoutFragment;
import demo.wrc.com.project.fragment.ui_material_design.RecyclerFragment;
import demo.wrc.com.project.fragment.ui_material_design.TableLayoutFragment;
import demo.wrc.com.project.fragment.ui_material_design.TranslucentScrollToolbarAndPaletteFragment;
import demo.wrc.com.project.listener.ItemClickSupport;
import demo.wrc.com.project.recycler.RecycleViewDivider;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class UIFragmentOne extends BaseFragment {
    
    
    private RecyclerView mRecyclerView;
    
    private  List<Map<String ,Class>> listTest;
    private RecyclerViewUIoneAdapter adapter;
    
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
        adapter = new RecyclerViewUIoneAdapter(UIFragmentOne.this, listTest);
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
    
                
                ToastUtil.toast("选中的Item："+listTest.get(position).keySet().toString());
                return false;
            }
        }).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
    
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
    
                Intent intent = new Intent(getActivity(), ActivityUI.class);
                intent.putExtra("fragment",listTest.get(position).get(listTest.get(position).keySet().toString().replace("[","").replace("]","")));
                startActivity(intent);
//                addMultipleFragments(R.id.frament_container_main,listTest.get(position).get(listTest.get(position).keySet().toString().replace("[","").replace("]","")));
            }
        });
        
        
        
    }
    
    
    protected List<Map<String ,Class>> testData() {
    
        listTest = new ArrayList<Map<String ,Class>>();
        Map<String ,Class> map1  = new HashMap<>();
        map1.put("RecyclerView",RecyclerFragment.class);
        listTest.add(map1);
        Map<String ,Class> map2  = new HashMap<>();
        map2.put("Palette",TranslucentScrollToolbarAndPaletteFragment.class);
        listTest.add(map2);
        Map<String ,Class> map3  = new HashMap<>();
        map3.put("TabLayout",TableLayoutFragment.class);
        listTest.add(map3);
    
        Map<String ,Class> map4  = new HashMap<>();
        map4.put("AppBarLayout",AppBarLayoutFragment.class);
        listTest.add(map4);
        
        Map<String ,Class> map5  = new HashMap<>();
        map5.put("AppBarViewpager",AppBarViewPagerFragment.class);
        listTest.add(map5);
    
        Map<String ,Class> map6  = new HashMap<>();
        map6.put("CollapsingToolbarLayout",CollapsingToolbarLayoutFragment.class);
        listTest.add(map6);
    
        Map<String ,Class> map7  = new HashMap<>();
        map7.put("Behavior",BehaviorFragment.class);
        listTest.add(map7);
    
        Map<String ,Class> map8  = new HashMap<>();
        map8.put("Animation",AnimationFragment.class);
        listTest.add(map8);
    
        Map<String ,Class> map0  = new HashMap<>();
        map0.put("-----",UIFragmentOne.class);
        listTest.add(map0);
        
        return listTest;
    }
    
    
    @Override
    public void onClick(View v) {
    }
}
