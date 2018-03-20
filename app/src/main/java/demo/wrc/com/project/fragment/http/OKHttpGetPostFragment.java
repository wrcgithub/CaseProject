package demo.wrc.com.project.fragment.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by wrc_urovo on 2018/1/8/008.
 */

public class OKHttpGetPostFragment extends BaseFragment {
    
    private TextView textView00, textView01;
    private ScrollView scrollView;
    private ImageView imageView;
    private Toolbar childToolBar;
    private String urlGet = "http://www.baidu.com";//请求地址
    private String urlPost = "http://www.baidu.com";//请求地址
    private String body = "{\"username\":\"wzwd\",\"nickname\":\"王者无敌\"}";//请求报文体
    private final int GET = 0;
    private final int POST = 1;
    
    
    @Override
    protected int getLayoutId() {
        
        return R.layout.fragment_http_okhttp_getpost;
    }
    
    
    @Override
    public void onResume() {
        
        super.onResume();
//        childToolBar.setTitle("HTTP篇");
        initToolBar("HTTP篇", "GET-POST", 0);
//        childToolBar.setTitleTextColor(getActivity().getResources().getColor(R.color.colorPrimary));
    }
    
    
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
//        initToolBar("UI篇","Translucent_Palette",0);
        toolbar.setVisibility(View.GONE);
        childToolBar = (Toolbar) view.findViewById(R.id.child_toolbar);
        scrollView = (ScrollView) view.findViewById(R.id.main_http_scrollview);
        imageView = (ImageView) view.findViewById(R.id.imageview01);
        textView00 = (TextView) view.findViewById(R.id.textView0);
        textView01 = (TextView) view.findViewById(R.id.textView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
            initHttpGet();
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            
            @Override
            public boolean onLongClick(View v) {
                initHttpPOST();
                
                return false;
            }
        });
        
    }
    
    
    /**
     * 初始化GET请求
     */
    private void initHttpGet() {
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(urlGet)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    //请求成功
                    int code = response.code();
                    String content = response.message();
                    String body = response.body().toString();
                    Message msg = new Message();
                    msg.what = GET;
                    msg.obj = body;
                    handler.sendMessage(msg);
                }else {
                    Message msg = new Message();
                    msg.what = GET;
                    msg.obj = "请求失败！";
                    handler.sendMessage(msg);
                }
            }
        }).start();
        
        
    }
    
    /**
     * 初始化POST请求
     */
    private void initHttpPOST() {
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");//数据类型：JSON
                RequestBody requestBody = RequestBody.create(mediaType,body);
                
                Request request = new Request.Builder()
                        .url(urlPost)
                        .post(requestBody)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    //请求成功
                    int code = response.code();
                    String content = response.message();
                    String body = response.body().toString();
                    
                    Message msg = new Message();
                    msg.what = POST;
                    msg.obj = body;
                    handler.sendMessage(msg);
                }else {
                    Message msg = new Message();
                    msg.what = POST;
                    msg.obj = "请求失败！";
                    handler.sendMessage(msg);
                }
            }
        }).start();
        
        
    }
    
    
    @Override
    protected void initData() {
    
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
    Handler handler = new Handler(){
    
        @Override
        public void handleMessage(Message msg) {
        
            super.handleMessage(msg);
            int ret = msg.what;
            String message = "返回信息："+(String) msg.obj;
            switch (ret){
                case GET:
                    textView00.setText("GET-"+message);
                    break;
                case POST:
                    textView00.setText("POST-"+message);
                    break;
                
            }
        }
    };
    
}
