package demo.wrc.com.project.utils;

/**
 * @author Administrator
 */
public class StringUtil {
	/** 判断手机是否挂载SD卡
	 * 判断手机是否有SD卡，并是可读写状态
	 */
	
	public static boolean isSDcard(){
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
				{
			return true;
				}
		return false;
	}
}
