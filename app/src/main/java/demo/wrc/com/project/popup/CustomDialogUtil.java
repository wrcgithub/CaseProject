package demo.wrc.com.project.popup;

import android.content.Context;
import android.view.View;

import demo.wrc.com.project.R;


/**
 * Created by wrc on 2017/11/30/030.
 */

public class CustomDialogUtil {
    
    public static CustomDialog dailog;
    
    
    public static void showDialog(Context context) {
        
        dailog = new CustomDialog.Builder(context).outSideCancel(false).view(R.layout.dialog_image)
                .widthDimenRes(R.dimen.dp200).heightDinmenRes(R.dimen.dp200).style(R.style.Dialog).addViewonclick(R.id.btn_cancel, new View.OnClickListener() {
                    
                    @Override
                    public void onClick(View v) {
                        
                        dailog.dismiss();
                    }
                }).build();
        dailog.show();
        ;
        
    }
    
    
}
