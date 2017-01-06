package service.group;

import java.util.Set;

/**
 * Created by gzy on 2017/1/6.
 */
public interface GroupService {

    public Set<Long> findShowGroupIds(Long userId, Set<Long> organizationIds);

}
