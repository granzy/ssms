package mappers.permission;

import domain.permission.RoleResourcePermission;

import java.util.List;

/**
 * \* User: gzy
 * \* Date: 2017/1/9
 * \* Time: 14:17
 * \* Description:
 * \
 */
public interface RoleResourcePermissionMapper {

    public List<RoleResourcePermission> findListByCondition(RoleResourcePermission r);

}
