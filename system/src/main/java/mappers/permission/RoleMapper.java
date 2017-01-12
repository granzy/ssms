package mappers.permission;

import domain.permission.Role;

import java.util.List;

/**
 * Created by gzy on 2017/1/6.
 */
public interface RoleMapper {
    public List<Role> findAll();
}
