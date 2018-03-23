package demo.wrc.com.project.fragment.sqlite.original;

import demo.wrc.com.project.fragment.sqlite.original.annotion.DbFiled;
import demo.wrc.com.project.fragment.sqlite.original.annotion.DbTable;


/**
 * Created by wrc on 2018/3/22/022.
 */
@DbTable("ta_common_user")
public class User {
    
    /**用户名*/
    @DbFiled("tb_name")
    private String name;
    
    /**用户密码*/
    @DbFiled("tb_password")
    private String password;

}
