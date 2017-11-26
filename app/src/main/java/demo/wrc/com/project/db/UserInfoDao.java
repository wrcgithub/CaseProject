package demo.wrc.com.project.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.wrc.com.project.model.UserInfo;


/**
 * 定义数据访问对象，对指定的用户数据表进行增删改查操作
 * Created by wrc on 2017/11/25/025.
 */
public class UserInfoDao {

    private Dao<UserInfo, Integer> userInfoDao;
    private DBHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public UserInfoDao(Context context) {
        try {
            dbHelper = DBHelper.getHelper(context);
            userInfoDao = dbHelper.getDao(UserInfo.class);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(UserInfo theme) {
        try {
            userInfoDao.create(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(UserInfo theme) {
        try {
            userInfoDao.delete(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(UserInfo theme) {
        try {
            userInfoDao.update(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public UserInfo queryForId(int id) {
        UserInfo theme = null;
        try {
            theme = userInfoDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theme;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<UserInfo> queryForAll() {
        List<UserInfo> themes = new ArrayList<UserInfo>();
        try {
            themes = userInfoDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }


}
