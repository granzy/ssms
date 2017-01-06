package service.auth;

import java.util.Set;

/**
 * Created by gzy on 2017/1/6.
 */
public interface AuthService {

    public Set<Long> findRoleIds(Long userId, Set<Long> groupIds, Set<Long> organizationIds, Set<Long> jobIds, Set<Long[]> organizationJobIds);

}
