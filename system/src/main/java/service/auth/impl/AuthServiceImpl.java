package service.auth.impl;

import com.google.common.collect.Sets;
import domain.user.UserOrganizationJob;
import mappers.auth.AuthMapper;
import service.auth.AuthService;

import javax.annotation.Resource;
import java.util.*;

/**
 * \* User: gzy
 * \* Date: 2017/1/6
 * \* Time: 14:57
 * \* Description:
 * \
 */
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthMapper authMapper;

    @Override
    public Set<Long> findRoleIds(Long userId, Set<Long> groupIds, Set<Long> organizationIds, Set<Long> jobIds, Set<Long[]> organizationJobIds) {
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("userId", userId);
        paramMap.put("groupIds", groupIds);
        paramMap.put("organizationIds", organizationIds);
        paramMap.put("jobIds", jobIds);
        List<UserOrganizationJob> uojList = new ArrayList<>();
        Iterator itOj = organizationJobIds.iterator();
        while (itOj.hasNext()) {
            Long[] l = (Long[]) itOj.next();
            if (l.length == 2) {
                UserOrganizationJob uoj = new UserOrganizationJob();
                uoj.setOrganizationId(l[0]);
                uoj.setJobId(l[1]);
                uojList.add(uoj);
            }
        }
        paramMap.put("organizationJobIds", uojList);

        List<Long> roleIdSets = authMapper.findRoleIds(paramMap);

        Set<Long> roleIds = Sets.newHashSet();
        for (Long roleId : roleIdSets) {
            roleIds.add(roleId);
        }
        return roleIds;
    }
}
