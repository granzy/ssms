package service.permission;

import domain.permission.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by gzy on 2017/1/6.
 */
public interface RoleService {

    public List<Role> findAll();

    public Set<Role> findShowRoles(Set<Long> roleIds);

}
