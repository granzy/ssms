package service.group.impl;

import com.google.common.collect.Sets;
import domain.group.Group;
import mappers.group.GroupMapper;
import mappers.group.GroupRelationMapper;
import org.springframework.stereotype.Service;
import service.group.GroupService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/6
 * \* Time: 13:35
 * \* Description:
 * \
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Resource
    private GroupRelationMapper groupRelationMapper;

    @Override
    public Set<Long> findShowGroupIds(Long userId, Set<Long> organizationIds) {
        Set<Long> groupIds = Sets.newHashSet();
        groupIds.addAll(groupMapper.findDefaultGroupIds());
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId",userId);
        paramMap.put("organizationIds",organizationIds);
        paramMap.put("isShow",true);
        groupIds.addAll(groupRelationMapper.findGroupIds(paramMap));

        return groupIds;
    }
}
