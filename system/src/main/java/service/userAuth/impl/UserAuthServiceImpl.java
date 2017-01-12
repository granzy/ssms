package service.userAuth.impl;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import domain.permission.Permission;
import domain.permission.Role;
import domain.permission.RoleResourcePermission;
import domain.user.User;
import domain.user.UserOrganizationJob;
import mappers.permission.PermissionMapper;
import mappers.permission.RoleResourcePermissionMapper;
import mappers.resource.ResourceMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.auth.AuthService;
import service.group.GroupService;
import service.job.JobService;
import service.organization.OrganizationService;
import service.permission.RoleService;
import service.resource.ResourceService;
import service.user.UserOrganizationJobService;
import service.userAuth.UserAuthService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 14:12
 * \* Description:
 * \
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

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

    @Resource
    private RoleService roleService;

    @Resource
    private RoleResourcePermissionMapper roleResourcePermissionMapper;

    @Resource
    private ResourceMapper resourceMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private ResourceService resourceService;

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

        Set<Role> roles = roleService.findShowRoles(roleIds);

        return roles;
    }

    @Override
    public Set<String> findStringPermissions(User user) {
        Set<String> permissions = Sets.newHashSet();
        /*TODO验证事务传播
        Set<Role> roles = ((UserAuthService) AopContext.currentProxy()).findRoles(user);
        */
        Set<Role> roles = findRoles(user);
        RoleResourcePermission roleResourcePermission = new RoleResourcePermission();
        List<RoleResourcePermission> rrpList = new ArrayList<>();
        for (Role role : roles) {
            roleResourcePermission.setRoleId(role.getId());
            rrpList = roleResourcePermissionMapper.findListByCondition(roleResourcePermission);
            for (RoleResourcePermission rrp : rrpList) {
                domain.resource.Resource resource = resourceMapper.findOne(rrp.getResourceId());

                String actualResourceIdentity = resourceService.findActualResourceIdentity(resource);

                //不可用 即没查到 或者标识字符串不存在
                if (resource == null || StringUtils.isEmpty(actualResourceIdentity) || Boolean.FALSE.equals(resource.getShow())) {
                    continue;
                }
                String permissionIds_str = rrp.getPermissionIds();
                if (!StringUtils.isEmpty(permissionIds_str)) {
                    String[] permissionIds_arr = permissionIds_str.split(",");
                    for (String permissionIdStr : permissionIds_arr) {
                        Long permissionId = Long.getLong(permissionIdStr);
                        Permission permission = permissionMapper.findOne(permissionId);

                        //不可用
                        if (permission == null || "0".equals(permission.getIsShow())) {
                            continue;
                        }
                        permissions.add(actualResourceIdentity + ":" + permission.getPermission());
                    }
                }
            }
        }
        return permissions;
    }

    public Set<String> findStringRoles(User user) {
        Set<Role> roles = ((UserAuthService) AopContext.currentProxy()).findRoles(user);
        return Sets.newHashSet(Collections2.transform(roles, new Function<Role, String>() {
            @Override
            public String apply(Role input) {
                return input.getRole();
            }
        }));
    }


}
