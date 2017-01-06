package domain.group;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 16:14
 * \* Description:
 * \
 */
public enum GroupType {

    user("用户组"), organization("组织机构组");

    private final String info;

    private GroupType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
