package service.userAuth.impl;

import com.google.common.collect.Sets;
import domain.permission.Role;
import domain.user.User;
import domain.user.UserOrganizationJob;
import service.auth.AuthService;
import service.group.GroupService;
import service.job.JobService;
import service.organization.OrganizationService;
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

    @Resource
    private OrganizationService organizationService;

    @Resource
    private JobService jobService;

    @Resource
    private GroupService groupService;

    @Resource
    private AuthService authService;

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

        //找组织机构祖先
        organizationIds.addAll(organizationService.findAncestorIds(organizationIds));

        //找工作职务的祖先
        jobIds.addAll(jobService.findAncestorIds(jobIds));

        //过滤组织机构 仅获取目前可用的组织机构数据
        organizationService.filterForCanShow(organizationIds, organizationJobIds);
        jobService.filterForCanShow(jobIds, organizationJobIds);

        //默认分组 + 根据用户编号 和 组织编号 找 分组
        Set<Long> groupIds = groupService.findShowGroupIds(userId, organizationIds);

        //获取权限
        //1.1、获取用户角色
        //1.2、获取组织机构角色
        //1.3、获取工作职务角色
        //1.4、获取组织机构和工作职务组合的角色
        //1.5、获取组角色
        Set<Long> roleIds = authService.findRoleIds(userId, groupIds, organizationIds, jobIds, organizationJobIds);

        return null;
    }
}
