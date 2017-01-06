package service.job.impl;

import com.google.common.collect.Sets;
import domain.job.Job;
import mappers.job.JobMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.job.JobService;

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
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Override
    public Job findOne(Long Long) {
        return jobMapper.findOne(Long);
    }

    @Override
    public Set<Long> findAncestorIds(Long currentId) {
        Set Longs = Sets.newHashSet();
        Job m = findOne(currentId);
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
     * @param jobIds
     * @param organizationJobIds
     */
    public void filterForCanShow(Set<Long> jobIds, Set<Long[]> organizationJobIds) {

        Iterator<Long> iter1 = jobIds.iterator();

        while (iter1.hasNext()) {
            Long id = iter1.next();
            Job o = findOne(id);
            if (o == null || Boolean.FALSE.equals(o.getShow())) {
                iter1.remove();
            }
        }

        Iterator<Long[]> iter2 = organizationJobIds.iterator();

        while (iter2.hasNext()) {
            Long id = iter2.next()[1];
            Job o = findOne(id);
            if (o == null || Boolean.FALSE.equals(o.getShow())) {
                iter2.remove();
            }
        }

    }


}
