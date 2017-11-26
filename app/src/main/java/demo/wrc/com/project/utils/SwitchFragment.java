package demo.wrc.com.project.utils;

import android.support.v7.app.AppCompatActivity;

import demo.wrc.com.project.base.BaseFragment;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class SwitchFragment {

    public void toFragment(AppCompatActivity mConText , int fragment_container , BaseFragment newFragment , String ... strings){


                mConText. getFragmentManager().beginTransaction()
                .add(fragment_container, newFragment)
                .addToBackStack(null)
                .commit();

    }

}
