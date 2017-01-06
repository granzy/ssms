package domain.user;

import base.entity.BaseEntity;

import java.util.Date;

/**
 * \* User: gzy
 * \* Date: 2017/1/3
 * \* Time: 17:11
 * \* Description:
 * \
 */
public class User extends BaseEntity<Long>{

    private String username;

    private String email;

    private String mobilePhoneNumber;

    private String password;

    private String salt;

    private Date createDate;

    /**
     * 用户状态
     */
    private UserStatus status = UserStatus.normal;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;

    /**
     * 逻辑删除flag
     */
    private Boolean deleted = Boolean.FALSE;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
