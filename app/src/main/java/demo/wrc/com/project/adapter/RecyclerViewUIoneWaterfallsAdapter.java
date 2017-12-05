package demo.wrc.com.project.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;


/**RecyclerView瀑布流的adapter适配器
 * Created by wrc_urovo on 2017/12/5/005.
 */

public class RecyclerViewUIoneWaterfallsAdapter extends RecyclerView.Adapter<RecyclerViewUIoneWaterfallsAdapter.AbViewHolder> {
    
    private List<String> list ;
    private BaseFragment fragment;
    private List<Integer> mHeight;
    
  public RecyclerViewUIoneWaterfallsAdapter(BaseFragment fragment, List<String> list){
    this.list = list;
    this.fragment = fragment;
    mHeight = new ArrayList<>();
    
    }
    
    @Override
    public AbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
      AbViewHolder viewHolder = new AbViewHolder(LayoutInflater.from(fragment.getActivity()).inflate(R.layout.recycler_ui_one,parent,false));
      
        return viewHolder;
    }
    
    
    @Override
    public void onBindViewHolder(AbViewHolder holder, int position) {
      
      String str = list.get(position);
      if (mHeight.size() <= position){
        mHeight.add((int)(100+Math.random() * 300));
      }
      
      ViewGroup.LayoutParams lp = holder.textView.getLayoutParams();
      lp.height = mHeight.get(position);
      holder.textView.setLayoutParams(lp);
      
      
      
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
        
        public TextView getTextView(){
            return  textView;
            
        }
    }
}
