package demo.wrc.com.project.utils;

import android.content.Context;

import java.io.File;


public class Files {
	public static String errfile = "";
	public static String fileData = "";

	public static void createFile(Context context) {
		try {

			errfile = "/storage/sdcard0/CaseDemo/ErrLog/";
			fileData = "/storage/sdcard0/CaseDemo/FileData/";

			File errfiles = new File(errfile);
			File fileDatas = new File(fileData);
			if (!errfiles.exists()) {
				errfiles.mkdirs();
			}

			if (!fileDatas.exists()) {
				fileDatas.mkdirs();
			}
			String cmd = "chmod 777 " + errfiles.getAbsolutePath();

			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
