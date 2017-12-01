package demo.wrc.com.project.popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import demo.wrc.com.project.R;
import demo.wrc.com.project.utils.DensityUtil;


/**
 * Created by wrc on 2017/11/30/030.
 */

public class ErrorDialog extends Dialog {
    
    public Context context;
    
    public ErrorDialog(Context context) {
        super(context);
        this.context = context;
    }
    
    public ErrorDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }
    
    public ErrorDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(context, R.layout.dialog_image01, null);
        setContentView(view);
        
        setCanceledOnTouchOutside(false);
        
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.height = DensityUtil.dip2px(context, 250);
        lp.width = DensityUtil.dip2px(context, 200);
        win.setAttributes(lp);
        
        view.findViewById(R.id.btn_cancel).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
    
}
