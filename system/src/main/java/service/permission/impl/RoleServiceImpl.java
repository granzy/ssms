package service.permission.impl;

import com.google.common.collect.Sets;
import domain.permission.Role;
import mappers.permission.RoleMapper;
import org.springframework.stereotype.Service;
import service.permission.RoleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/6
 * \* Time: 15:31
 * \* Description:
 * \
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    /**
     * 获取可用的角色列表
     *
     * @param roleIds
     * @return
     */
    @Override
    public Set<Role> findShowRoles(Set<Long> roleIds) {

        Set<Role> roles = Sets.newHashSet();

        //TODO 如果角色很多 此处应该写查询
        for (Role role : findAll()) {
            if (Boolean.TRUE.equals(role.getShow()) && roleIds.contains(role.getId())) {
                roles.add(role);
            }
        }
        return roles;
    }

}
