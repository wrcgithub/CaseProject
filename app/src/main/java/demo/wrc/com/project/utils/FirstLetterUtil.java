package demo.wrc.com.project.utils;

/**
 * Created by Administrator on 0027 08/27.
 */
public class FirstLetterUtil {

    public static String getFirstLetter(String str) {

        String returnStr = null;
        try {
            returnStr = str.substring(0, 1);
        } catch (Exception e) {
            e.printStackTrace();
            returnStr = "";
        }
        return returnStr;
    }
}
