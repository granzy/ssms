package service.organization.impl;

import com.google.common.collect.Sets;
import domain.organization.Organization;
import mappers.organization.OrganizationMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.organization.OrganizationService;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 14:56
 * \* Description:
 * \
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public Organization findOne(Long Long) {
        return organizationMapper.findOne(Long);
    }

    @Override
    public Set<Long> findAncestorIds(Long currentId) {
        Set Longs = Sets.newHashSet();
        Organization m = findOne(currentId);
        if (m == null) {
            return Longs;
        }
        for (String LongStr : StringUtils.tokenizeToStringArray(m.getParentIds(), "/")) {
            if (!StringUtils.isEmpty(LongStr)) {
                Longs.add(Long.valueOf(LongStr));
            }
        }
        return Longs;
    }

    @Override
    public Set<Long> findAncestorIds(Iterable<Long> currentIds) {
        Set<Long> parents = Sets.newHashSet();
        for (Long currentId : currentIds) {
            parents.addAll(findAncestorIds(currentId));
        }
        return parents;
    }

    /**
     * 过滤仅获取可显示的数据
     *
     * @param organizationIds
     * @param organizationJobIds
     */
    public void filterForCanShow(Set<Long> organizationIds, Set<Long[]> organizationJobIds) {

        Iterator<Long> iter1 = organizationIds.iterator();

        while (iter1.hasNext()) {
            Long id = iter1.next();
            Organization o = findOne(id);
            if (o == null || Boolean.FALSE.equals(o.getShow())) {
                iter1.remove();
            }
        }

        Iterator<Long[]> iter2 = organizationJobIds.iterator();

        while (iter2.hasNext()) {
            Long id = iter2.next()[0];
            Organization o = findOne(id);
            if (o == null || Boolean.FALSE.equals(o.getShow())) {
                iter2.remove();
            }
        }

    }


}
