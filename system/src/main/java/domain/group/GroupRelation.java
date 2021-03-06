package domain.group;


/**
 * 分组与 用户/组织机构关系表
 * <p/>
 * 将用户/组织机构放一张表目的是提高查询性能
 * <p/>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-4-19 下午3:44
 * <p>Version: 1.0
 */

import base.entity.BaseEntity;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 16:14
 * \* Description:
 * \
 */
public class GroupRelation extends BaseEntity<Long> {

    private Long groupId;

    private Long organizationId;

    /**
     * 关联的单个用户
     */
    private Long userId;

    /**
     * 关联的 区间user id 作为单个关联的一种优化
     * 和user二者选一
     * [startUserId, endUserId]闭区间
     */
    private Long startUserId;

    private Long endUserId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(Long startUserId) {
        this.startUserId = startUserId;
    }

    public Long getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Long endUserId) {
        this.endUserId = endUserId;
    }
}
