package mappers.job;

import domain.job.Job;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 11:41
 * \* Description:
 * \
 */
public interface JobMapper {
    Job findOne(Long id);
}

