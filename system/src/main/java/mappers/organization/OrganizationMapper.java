package mappers.organization;

import domain.organization.Organization;

/**
 * \* User: gzy
 * \* Date: 2017/1/5
 * \* Time: 11:41
 * \* Description:
 * \
 */
public interface OrganizationMapper {
    Organization findOne(Long id);
}

