package demo.wrc.com.project.fragment;

import android.os.Bundle;
import android.view.View;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.custemview.CircleImageView;
import demo.wrc.com.project.popup.CustomDialogUtil;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class ChangeUserInfoFragment extends BaseFragment {


    private CircleImageView circleImageView;
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_change_userinfo;
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
    
        circleImageView = (CircleImageView) view.findViewById(R.id.userinfo_set_img);
        circleImageView.setOnClickListener(this);
    }


    @Override
    protected void initData() {
    
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.userinfo_set_img:
                CustomDialogUtil.showDialog(getActivity());
                ToastUtil.showToast(getActivity(),"点我干嘛",0);
                break;


            default:

                break;


        }

    }
}
