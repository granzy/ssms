package domain.permission;

import base.entity.BaseEntity;

/**
 * \* User: gzy
 * \* Date: 2017/1/9
 * \* Time: 14:09
 * \* Description:角色资源权限关联表
 * \
 */
public class RoleResourcePermission extends BaseEntity {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourceId;

    /**
     * 资源ids
     */
    private String permissionIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
