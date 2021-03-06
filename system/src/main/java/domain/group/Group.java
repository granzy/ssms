package domain.group;


import base.entity.BaseEntity;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 16:14
 * \* Description:
 * \
 */
public class Group extends BaseEntity<Long> {
    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组类型 如 用户分组/组织机构分组
     */
    private String type;

    /**
     * 是否是默认分组
     */
    private Boolean defaultGroup = Boolean.FALSE;

    /**
     * 是否显示/可用
     */
    private Boolean isShow = Boolean.FALSE;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(Boolean defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }
}
