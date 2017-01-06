package domain.user;

/**
 * \* User: gzy
 * \* Date: 2017/1/3
 * \* Time: 17:11
 * \* Description:
 * \
 */
public enum UserStatus {

    normal("正常状态"), blocked("封禁状态");

    private final String info;

    private UserStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}