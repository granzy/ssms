package service.userAuth;

import domain.permission.Role;
import domain.user.User;

import java.util.Set;

/**
 * Created by gzy on 2017/1/4.
 */
public interface UserAuthService {

    public Set<Role> findRoles(User user);

    public Set<String> findStringRoles(User user);

    public Set<String> findStringPermissions(User user);
}
