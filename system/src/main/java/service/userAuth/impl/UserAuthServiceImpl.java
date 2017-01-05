package service.userAuth.impl;

import com.google.common.collect.Sets;
import domain.permission.Role;
import domain.user.User;
import domain.user.UserOrganizationJob;
import service.user.UserOrganizationJobService;
import service.userAuth.UserAuthService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 14:12
 * \* Description:
 * \
 */
public class UserAuthServiceImpl implements UserAuthService{

    @Resource
    private UserOrganizationJobService userOrganizationJobService;

    @Override
    public Set<Role> findRoles(User user) {

        Long userId = user.getId();
        List<UserOrganizationJob> userOrganizationJobs = userOrganizationJobService.findByUserId(userId);

        Set<Long[]> organizationJobIds = Sets.newHashSet();
        Set<Long> organizationIds = Sets.newHashSet();
        Set<Long> jobIds = Sets.newHashSet();

        for (UserOrganizationJob o : userOrganizationJobs) {
            Long organizationId = o.getOrganizationId();
            Long jobId = o.getJobId();

            if (organizationId != null && jobId != null && organizationId != 0L && jobId != 0L) {
                organizationJobIds.add(new Long[]{organizationId, jobId});
            }
            organizationIds.add(organizationId);
            jobIds.add(jobId);
        }
        return null;
    }
}
