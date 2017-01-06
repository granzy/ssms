package service.job;

import domain.job.Job;

import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 14:51
 * \* Description:
 * \
 */
public interface JobService {

    public Job findOne(Long Long);

    public Set<Long> findAncestorIds(Long currentId);

    public Set<Long> findAncestorIds(Iterable<Long> currentIds);

    public void filterForCanShow(Set<Long> jobIds, Set<Long[]> organizationJobIds);

}
