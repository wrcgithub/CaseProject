package demo.wrc.com.project.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc_urovo on 2017/12/5/005.
 */

public class RecyclerViewUIoneAdapter extends RecyclerView.Adapter<RecyclerViewUIoneAdapter.AbViewHolder> {
    
    private List<String> list ;
    private BaseFragment fragment;
    
  public   RecyclerViewUIoneAdapter(BaseFragment fragment,List<String> list){
    this.list = list;
    this.fragment = fragment;
    
    
    }
    
    @Override
    public AbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
      AbViewHolder viewHolder = new AbViewHolder(LayoutInflater.from(fragment.getActivity()).inflate(R.layout.recycler_ui_one,parent,false));
      
        return viewHolder;
    }
    
    
    @Override
    public void onBindViewHolder(AbViewHolder holder, int position) {
    holder.textView.setText(list.get(position));
    }
    
    
    
    
    @Override
    public int getItemCount() {
        
        return list.size();
    }
    
    public class AbViewHolder extends RecyclerView.ViewHolder{
    
        TextView textView;
        public AbViewHolder(View itemView) {
        
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recycler_ui_item_text);
        }
    }
}
