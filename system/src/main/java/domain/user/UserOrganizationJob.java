package domain.user;

import domain.BaseEntity;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 15:12
 * \* Description:
 * \
 */
public class UserOrganizationJob extends BaseEntity<Long> {

    private Long organizationId;

    private Long jobId;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
