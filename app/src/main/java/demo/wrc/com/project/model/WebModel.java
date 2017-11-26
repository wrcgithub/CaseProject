package demo.wrc.com.project.model;

import java.io.Serializable;


/**
 * Created by Administrator on 0025 08/25.
 */
public class WebModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private String indexID;
    private  String webName;
    private  String webSite;
    private String nickName;
    private String account; //账号
    private String email ;
    private String secretCode;
    private String secretSecurity;//密保问题
    private String createTime ;

    public String getIndexID() {
        return indexID;
    }


    public void setIndexID(String indexID) {
        this.indexID = indexID;
    }

    public String getWebName() {

        return webName;
    }


    public void setWebName(String webName) {

        this.webName = webName;
    }
    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getWebSite() {

        return webSite;
    }


    public void setWebSite(String webSite) {

        this.webSite = webSite;
    }


    public String getNickName() {

        return nickName;
    }


    public void setNickName(String nickName) {

        this.nickName = nickName;
    }


    public String getAccount() {

        return account;
    }


    public void setAccount(String account) {

        this.account = account;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public String getSecretCode() {

        return secretCode;
    }


    public void setSecretCode(String secretCode) {

        this.secretCode = secretCode;
    }


    public String getSecretSecurity() {

        return secretSecurity;
    }


    public void setSecretSecurity(String secretSecurity) {

        this.secretSecurity = secretSecurity;
    }
}