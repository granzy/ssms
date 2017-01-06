package service.organization;

import domain.organization.Organization;

import java.util.Set;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 14:51
 * \* Description:
 * \
 */
public interface OrganizationService{

    public Organization findOne(Long Long);

    public Set<Long> findAncestorIds(Long currentId) ;

    public Set<Long> findAncestorIds(Iterable<Long> currentIds);

    public void filterForCanShow(Set<Long> organizationIds, Set<Long[]> organizationJobIds);

}
