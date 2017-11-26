package demo.wrc.com.project.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import demo.wrc.com.project.model.WebModel;


/**
 * Created by Administrator on 0027 08/27.
 */
public class SearchLocal {

    /**
     * 按群号-群名拼音搜索
     *
     * @param str
     */
    public static List<WebModel> searchWebModel(CharSequence str,
                                                List<WebModel> allContacts) {
        List<WebModel> WebModelList = new ArrayList<WebModel>();
        // 如果搜索条件以0 1 +开头则按号码搜索
        if (str.toString().startsWith("0") || str.toString().startsWith("1")
                || str.toString().startsWith("+")) {
            for (WebModel WebModel : allContacts) {
                if (getWebModelName(WebModel) != null
                        && WebModel.getWebName() + "" != null) {
                    if ((WebModel.getWebName() + "").contains(str)
                           ) {
                        WebModelList.add(WebModel);
                    }
                }
            }
            return WebModelList;
        }
        CharacterParser finder = CharacterParser.getInstance();

        String result = "";
        for (WebModel WebModel : allContacts) {
            // 先将输入的字符串转换为拼音
            finder.setResource(str.toString());
            result = finder.getSpelling();
            if (contains(WebModel, result)) {
                WebModelList.add(WebModel);
            } else if ((WebModel.getWebName() + "").contains(str)) {
                WebModelList.add(WebModel);
            }
        }
        return WebModelList;
    }

    /**
     * 根据拼音搜索
     *
     *            正则表达式
     *            拼音
     *            搜索条件是否大于6个字符
     * @return
     */
    private static boolean contains(WebModel WebModel, String search) {
        if (TextUtils.isEmpty(WebModel.getWebName())
               ) {
            return false;
        }

        boolean flag = false;

        // 简拼匹配,如果输入在字符串长度大于6就不按首字母匹配了
        if (search.length() < 6) {
            String firstLetters = FirstLetterUtil.getFirstLetter(getWebModelName(WebModel));
            // 不区分大小写
            Pattern firstLetterMatcher = Pattern.compile(search,
                    Pattern.CASE_INSENSITIVE);
            flag = firstLetterMatcher.matcher(firstLetters).find();
        }

        if (!flag) { // 如果简拼已经找到了，就不使用全拼了
            // 全拼匹配
            CharacterParser finder = CharacterParser.getInstance();
            finder.setResource(getWebModelName(WebModel));
            // 不区分大小写
            Pattern pattern2 = Pattern
                    .compile(search, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(finder.getSpelling());
            flag = matcher2.find();
        }

        return flag;
    }

    private static String getWebModelName(WebModel WebModel) {
        String strName = null;
        if (!TextUtils.isEmpty(WebModel.getWebName())) {
            strName = WebModel.getWebName();
        }
//        else if (!TextUtils.isEmpty(WebModel.getRoomName())) {
//            strName = WebModel.getRoomName();
//        }
        else {
            strName = "";
        }

        return strName;
    }

}
