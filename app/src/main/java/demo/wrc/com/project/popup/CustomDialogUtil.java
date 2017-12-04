package demo.wrc.com.project.popup;

import android.content.Context;
import android.view.View;

import demo.wrc.com.project.R;
import demo.wrc.com.project.callback.OnClickDialog;


/**
 * Created by wrc on 2017/11/30/030.
 */

public class CustomDialogUtil {
    
    public static CustomDialog dailog;
    
    
    public static void showDialogConfirmImg(Context context, final boolean flag, final String msg , final  OnClickDialog linstener) {
        
        dailog = new CustomDialog.Builder(context).outSideCancel(false).view(R.layout.dialog_image01)
                .widthDimenRes(R.dimen.dp200).heightDinmenRes(R.dimen.dp250).style(R.style.Dialog).addViewonclick(R.id.dialog_btn_cancel, new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        linstener.confirm(flag,msg);
                        dailog.dismiss();
                    }
                })
                .setText(R.id.dialog_one_text,msg)
                .build();
        dailog.show();
        ;
        
    }
    public static void showDialogTwoImg(Context context, final boolean flag, final String leftText, final String rightText, final String msg , final int drawableleftRes , final int drawableRightRes , final  OnClickDialog linstener) {
        
        dailog = new CustomDialog.Builder(context).outSideCancel(false).view(R.layout.dialog_image02)
                .widthDimenRes(R.dimen.dp200).heightDinmenRes(R.dimen.dp200).style(R.style.Dialog).addViewonclick(R.id.dialog_left_img, new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        linstener.confirm(flag,msg);
                        dailog.dismiss();
                    }
                })
                .addViewonclick(R.id.dialog_left_img, new View.OnClickListener() {
    
                    @Override
                    public void onClick(View v) {
                        linstener.cancel(msg);
                        dailog.dismiss();
                    }
                })
                .setText(R.id.dialog_left_text,leftText)
                .setText(R.id.dialog_right_text,rightText)
                .setImage(R.id.dialog_left_img,drawableleftRes)
                .setImage(R.id.dialog_right_img,drawableRightRes)
                .build();
        dailog.show();
        ;
        
    }
    
}
