package demo.wrc.com.project.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


/**
 * 用户数据表
 * Created by wrc on 2017/11/25/025.
 */
@DatabaseTable(tableName = "UserInfo")
public class UserInfo implements Serializable {
    /**
     * 检索ID
     */
    public static  final String id_Field = "id";
    /**
     * 用户编号
     */
    public static  final String userNumber_Field = "userNumber";
    /**
     * 用户名称
     */
    public static  final String userName_Field = "userName";
    /**
     * 用户出生年月
     */
    public static  final String birthDate_Field = "birthDate";
    /**
     * 用户上次登陆时间
     */
    public static  final String loginDate_Field = "loginDate";
    /**
     * 用户邮箱
     */
    public static  final String email_Field = "email";
    /**
     * 用户性别
     */
    public static  final String sex_Field = "sex";
    /**
     * 用户个性签名
     */
    public static  final String remark_Field = "remark";


    /**
     * 检索ID
     */
    @DatabaseField(id = true)
    public int id;


    /**
     * 用户编号
     */
    @DatabaseField
    public String userNumber;

    /**
     * 用户名称
     */
    @DatabaseField
    public String userName;

    /**
     * 用户出生年月
     */
    @DatabaseField
    public String birthDate;

    /**
     * 用户上次登陆时间
     */
    @DatabaseField()
    public long loginDate;

    /**
     * 用户邮箱
     */
    @DatabaseField
    public String email;

    /**
     * 用户性别
     */
    @DatabaseField
    public String sex;

    /**
     * 用户个新签名
     */
    @DatabaseField
    public String remark;

    // 一个套餐可以对应多个主题
//    @ForeignCollectionField(eager = true) // 必须
//    public ForeignCollection<其他对象> themes;



    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", userNumber=" + userNumber + ", userName="
                + userName + ", birthDate=" + birthDate + ", email=" + email+ ", loginDate=" + loginDate
                + ", sex=" + sex + ", remark=" + remark + "]";
    }


}
