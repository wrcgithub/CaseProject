package demo.wrc.com.project.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import demo.wrc.com.project.R;
import demo.wrc.com.project.base.BaseFragment;
import demo.wrc.com.project.callback.OnClickDialog;
import demo.wrc.com.project.custemview.CircleImageView;
import demo.wrc.com.project.popup.CustomDialogUtil;
import demo.wrc.com.project.utils.ToastUtil;


/**
 * Created by wrc on 2017/11/26/026.
 */
public class ChangeUserInfoFragment extends BaseFragment {
    
    
    private CircleImageView circleImageView;
    private Bitmap head;//头像Bitmap
    private static String path = "/sdcard/CaseDemo/UserInfo";//sd路径
    //(/sdcard/  目录怎么感觉跟Environment.getExternalStorageDirectory()得到的目录是一个效果？)
    
    
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
        
        switch (v.getId()) {
            case R.id.userinfo_set_img:
//                CustomDialogUtil.showDialogConfirmImg(getActivity(), true, "进入相册", new OnClickDialog() {
//
//                    @Override
//                    public void confirm(boolean flag, String msg) {
//                        switchPhoto();
//                    }
//
//
//                    @Override
//                    public void cancel(String errMsg) {
//
//                    }
//                });
    
                CustomDialogUtil.showDialogTwoImg(getActivity(), false, "相册", "相机", "头像获取方式", R.mipmap.dialog_default01, R.mipmap.dialog_default01, new OnClickDialog() {
    
                    @Override
                    public void confirm(boolean flag, String msg) {
                        switchPhoto();
                    }
    
    
                    @Override
                    public void cancel(String errMsg) {
    
                        ToastUtil.showToast(getActivity(),"暂不支持", 0);
                    }
                });
                
                break;
            
            
            default:
                
                break;
            
            
        }
        
    }
    
    
    private void switchPhoto() {
        
        Intent intent1 = new Intent(Intent.ACTION_PICK, null);//返回被选中项的URI
        intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");//得到所有图片的URI
//                System.out.println("MediaStore.Images.Media.EXTERNAL_CONTENT_URI  ------------>   "
//                        + MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//   content://media/external/images/media
        startActivityForResult(intent1, 1);
        
    }
    
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        super.onActivityResult(requestCode, resultCode, data);
        
        if (resultCode != AppCompatActivity.RESULT_OK) {
            return;
        }
        
        switch (requestCode) {
            case 1:
                cropPhoto(data.getData());//裁剪图片
                break;
            case 2:
//                    File temp = new File(Environment.getExternalStorageDirectory()
//                            + "/head.jpg");
                File temp = new File(path + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));//裁剪图片
                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */
                        setPicToView(head);//保存在SD卡中
                        circleImageView.setImageBitmap(head);//用ImageView显示出来
                    }
                }
                break;
            
            
        
    }
    
    
}
    
    
    /**
     * 调用系统的裁剪
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        
        Intent intent = new Intent("com.android.camera.action.CROP");
        //找到指定URI对应的资源图片
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        //进入系统裁剪图片的界面
        startActivityForResult(intent, 3);
    }
    
    
    private void setPicToView(Bitmap mBitmap) {
        
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd卡是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建以此File对象为名（path）的文件夹
        String fileName = path + "head.jpg";//图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件（compress：压缩）
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    
}
