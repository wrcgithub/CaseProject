package demo.wrc.com.project.callback;

/**
 * Created by wrc_urovo on 2017/12/1/001.
 */

public interface OnClickDialogChoice {
    
        void confirm(boolean flag , String msg);
        void cancel(String errMsg);
}
