package mappers.permission;

import domain.permission.Permission;

/**
 * \* User: gzy
 * \* Date: 2017/1/9
 * \* Time: 15:26
 * \* Description:
 * \
 */
public interface PermissionMapper {

    public Permission findOne(Long id);

}
