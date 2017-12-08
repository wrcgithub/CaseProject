package demo.wrc.com.project.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.model.TestInfo;


/**
 * RecyclerView瀑布流的adapter适配器
 * Created by wrc_urovo on 2017/12/5/005.
 */

public class RecyclerViewUIoneWaterfallsAdapter extends RecyclerView.Adapter<RecyclerViewUIoneWaterfallsAdapter.AbViewHolder> {
    
    private List<TestInfo> list;
    private BaseFragment fragment;
    private List<Integer> mHeight;
    
    
    public RecyclerViewUIoneWaterfallsAdapter(BaseFragment fragment, List<TestInfo> list) {
        
        this.list = list;
        this.fragment = fragment;
        mHeight = new ArrayList<>();
        
    }
    
    
    @Override
    public AbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
        AbViewHolder viewHolder = new AbViewHolder(LayoutInflater.from(fragment.getActivity()).inflate(R.layout.recycler_ui_one, parent, false));
        
        return viewHolder;
    }
    
    
    //添加数据
    public void addItem(int position, String data) {
        
        TestInfo testInfo = new TestInfo();
        testInfo.setName(data);
        testInfo.setTrue(false);
        list.add(position, testInfo);
        notifyItemInserted(position);//通知演示插入动画
        notifyItemRangeChanged(position, list.size() - position);//通知数据与界面重新绑定
    }
    
    
    // 删除数据
    public void removeData(int position) {
        
        list.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
    
    
    @Override
    public void onBindViewHolder(final AbViewHolder holder, final int position) {
        
        String str = list.get(position).getName();
        if (mHeight.size() <= position) {
            mHeight.add((int) (50 + Math.random() * 20));
        }
        
        ViewGroup.LayoutParams lp = holder.linearLayout.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.linearLayout.setLayoutParams(lp);
        
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                holder.checkBox.setChecked(!list.get(position).isTrue());
                list.get(position).setTrue(!list.get(position).isTrue());
                
            }
        });
        holder.checkBox.setChecked(list.get(position).isTrue());
        holder.textView.setText(list.get(position).getName());
    }
    
    
    @Override
    public int getItemCount() {
        
        return list.size();
    }
    
    
    public class AbViewHolder extends RecyclerView.ViewHolder {
        
        LinearLayout linearLayout;
        TextView textView;
        CheckBox checkBox;
        
        
        public AbViewHolder(View itemView) {
            
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.recycler_ui_one_item);
            textView = (TextView) itemView.findViewById(R.id.recycler_ui_item_text);
            checkBox = (CheckBox) itemView.findViewById(R.id.recycler_ui_item_checkbox);
        }
        
    }
}
